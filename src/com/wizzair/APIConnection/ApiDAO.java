package com.wizzair.APIConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.wizzair.exceptions.FlightException;
import com.wizzair.model.FlightSearch;
import com.wizzair.model.JsonFlight;

public class ApiDAO {

	private static final String API_KEY = "zd245468154105197435988199897794";
	private static final String COMPANY_CODE = "1914";
	private static final String COMPANY_NAME = "Wizz Air";

	public static List<JsonFlight> getFlights(FlightSearch search) throws Exception {

		String location = getLocation(search);

		return getFlightsQuery(search, location);
	}

	private static List<JsonFlight> getFlightsQuery(FlightSearch search, String location) throws Exception {
		
		int stopsSearch = search.getStops();
		String carriersKey = "&includecarriers=W6";
		
		String request2 = location + "?apiKey=" + API_KEY + "&stops=" + stopsSearch;
		
		// the flight is direct
		if (stopsSearch == 0) {
			request2 = request2 + carriersKey;
		}

		URL url2 = new URL(request2);
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

		conn2.setRequestProperty("Accept", "application/json");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject object = null;
		List<JsonFlight> flights = new ArrayList<JsonFlight>();
		Map<Integer, JsonFlight> flightsWithStops = new HashMap<Integer, JsonFlight>();
		Map<String, HashMap<String, Double>> flightIds = new HashMap<String, HashMap<String, Double>>();
		Map<String, String> carriersMap = new HashMap<String, String>();
		Map<String, String> agentsMap = new HashMap<String, String>();
		Map<String, String> placesMap = new HashMap<String, String>();

		try {
			// if too many request
			if (conn2.getResponseCode() == 429) {
				Map<String, String> map2 = new HashMap<String, String>();

				for (String header : conn2.getHeaderFields().keySet()) {
					if (header != null) {
						for (String value : conn2.getHeaderFields().get(header)) {
							System.out.println(header + ":" + value);
							map2.put(header, value);
						}
					}
				}
			}
			//Continue polling if the previous polling response is 304
			if (conn2.getResponseCode() == 304) {
				// wait 1 sec and poll again
				Thread.sleep(1000);
				return getFlightsQuery(search, location);
			}
			//Continue polling if the previous polling response is 200 and status is UpdatesPending
			if (conn2.getResponseCode() == 200) {
				JsonElement element =  new JsonParser().parse(response.toString());
				if (element.isJsonNull()){
					return getFlightsQuery(search,location);
				}
				object = (JsonObject) element;
				if (object.get("Status").getAsString().equals("UpdatesPending")) {
					Thread.sleep(1000);
					return getFlightsQuery(search, location);
				}
			}
	
			// all carriers with flights
			JsonArray carriers = object.getAsJsonArray("Carriers");

			for (int number = 0; number < carriers.size(); number++) {
				JsonObject jsonCarrier = carriers.get(number).getAsJsonObject();

				String id = jsonCarrier.get("Id").getAsString();
				String name = jsonCarrier.get("Name").getAsString();
				carriersMap.put(id, name);
			}

			// all agents with prices for flights
			JsonArray itineraries = object.getAsJsonArray("Itineraries");
			for (int itin = 0; itin < itineraries.size(); itin++) {
				JsonObject outboundLegId = itineraries.get(itin).getAsJsonObject();
				String legId = outboundLegId.get("OutboundLegId").getAsString();
				flightIds.put(legId, new HashMap<String, Double>());

				JsonArray pricingOptions = outboundLegId.getAsJsonArray("PricingOptions");
				for (int i = 0; i < pricingOptions.size(); i++) {
					String agentId = "";
					double price = 0;
					JsonObject agent = pricingOptions.get(i).getAsJsonObject();
					agentId = agent.get("Agents").getAsString();
					price = agent.get("Price").getAsDouble();
					flightIds.get(legId).put(agentId, price);
				}
			}

			// all flights - full information + info about transfers (if any)
			JsonArray legs = object.getAsJsonArray("Legs");

			for (int i = 0; i < legs.size(); i++) {
				JsonObject flight = legs.get(i).getAsJsonObject();

				String id = flight.get("Id").getAsString();
				String originStation = flight.get("OriginStation").getAsString();
				String destinationStation = flight.get("DestinationStation").getAsString();
				String departure = flight.get("Departure").getAsString();
				String arrival = flight.get("Arrival").getAsString();
				String duration = flight.get("Duration").getAsString();
				JsonArray carriersLeg = flight.get("Carriers").getAsJsonArray();
				String[] carrier = new String[carriersLeg.size()];
				Set<String> carriersSet = new HashSet<String>();
				for (int j = 0; j < carriersLeg.size(); j++) {
					carriersSet.add(carriersLeg.get(j).getAsString());
					carrier[j] = carriersLeg.get(j).getAsString();
				}
				
				//add only flights where Wizz Air takes part
				/*if (!(carriersSet.contains(COMPANY_CODE))) { 
					 continue; 
				}*/
				
				JsonArray stopsArr = flight.get("Stops").getAsJsonArray();
				String[] stops = new String[stopsArr.size()];
				for (int stop = 0; stop < stopsArr.size(); stop++) {
					stops[stop] = stopsArr.get(stop).getAsString();
				}
				JsonArray segmentIdsArr = flight.get("SegmentIds").getAsJsonArray();
				int[] segmentIds = new int[segmentIdsArr.size()];
				for (int index = 0; index < segmentIdsArr.size(); index++) {
					segmentIds[index] = segmentIdsArr.get(index).getAsInt();
				}

				flights.add(new JsonFlight(id, originStation, destinationStation, departure, arrival, duration, carrier,
						stops, segmentIds));

			}

			// all direct flights (needed to get those with transfer)
			JsonArray segments = object.getAsJsonArray("Segments");

			for (int i = 0; i < segments.size(); i++) {
				JsonObject flight = segments.get(i).getAsJsonObject();

				int id = flight.get("Id").getAsInt();
				String originStation = flight.get("OriginStation").getAsString();
				String destinationStation = flight.get("DestinationStation").getAsString();
				String departure = flight.get("DepartureDateTime").getAsString();
				String arrival = flight.get("ArrivalDateTime").getAsString();
				String duration = flight.get("Duration").getAsString();
				String carriersInSegment = flight.get("Carrier").getAsString();
				String[] carrier = { carriersInSegment };

				flightsWithStops.put(id,
						new JsonFlight(originStation, destinationStation, departure, arrival, duration, carrier));
			}

			// all agents
			JsonArray agents = object.getAsJsonArray("Agents");

			for (int index = 0; index < agents.size(); index++) {

				JsonObject jsonAgent = agents.get(index).getAsJsonObject();

				String id = jsonAgent.get("Id").getAsString();
				String name = jsonAgent.get("Name").getAsString();
				agentsMap.put(name, id);
			}

			// contains places(origin, destination) where to an id correspond a name
			JsonArray places = object.getAsJsonArray("Places");

			for (int index = 0; index < places.size(); index++) {

				JsonObject jsonPlace = places.get(index).getAsJsonObject();

				String id = jsonPlace.get("Id").getAsString();
				String name = jsonPlace.get("Name").getAsString();
				placesMap.put(id, name);
			}

			// set lowest price and agent to all flights
			for (int flight = 0; flight < flights.size(); flight++) {
				double lowestPrice = Double.MAX_VALUE;
				String ticketSeller = "";
				String flightId = flights.get(flight).getId();
				HashMap<String, Double> agentAndPrice = flightIds.get(flightId);
				//get the id for COMPANY_NAME
				String agentNumber = agentsMap.get(COMPANY_NAME);
				for (Entry<String, Double> agent : agentAndPrice.entrySet()) {
					
					//check if the COMPANY_NAME had set a price, else choose the lowest one
					if (agentAndPrice.containsKey(agentNumber)) {
						ticketSeller = COMPANY_NAME;
						lowestPrice = agentAndPrice.get(agentNumber);
						break;
					} else {
	
						double price = agent.getValue();
						if (price < lowestPrice) {
							lowestPrice = price;
							ticketSeller = agent.getKey();
						}
					}
				}

				for (Entry<String, String> agentId : agentsMap.entrySet()) {

					if (agentId.getValue().equals(ticketSeller)) {
						ticketSeller = agentId.getKey();
						break;
					}

				}

				flights.get(flight).setPrice(lowestPrice);
				flights.get(flight).setTicketSeller(ticketSeller);

				// replace carrier id with name
				for (int i = 0; i < flights.get(flight).getCarriers().length; i++) {
					String name = flights.get(flight).getCarriers()[i];
					flights.get(flight).setCarrierName(i, carriersMap.get(name));

				}

				// replace origin and destination id with name
				String origin = placesMap.get(flights.get(flight).getOriginStation());
				String destination = placesMap.get(flights.get(flight).getDestinationStation());

				flights.get(flight).setOriginStation(origin);
				flights.get(flight).setDestinationStation(destination);

				// replace stops id with name
				for (int stop = 0; stop < flights.get(flight).getStops().length; stop++) {
					String stopName = flights.get(flight).getStops()[stop];
					flights.get(flight).setStopName(stop, placesMap.get(stopName));
				}
			}

			// set nested flights (if any)
			for (int flight = 0; flight < flights.size(); flight++) {
				
				//if this is a direct flight - lenght = 1
				if (flights.get(flight).getSegmentIds().length > 1) {
					for (int innerFlight = 0; innerFlight < flights.get(flight).getSegmentIds().length; innerFlight++) {
						
						if (flightsWithStops.containsKey(flights.get(flight).getSegmentIds()[innerFlight])) {
							flights.get(flight)
									.addFlights(flightsWithStops.get(flights.get(flight).getSegmentIds()[innerFlight]));
						}
						
					}
				}
			}

			// set nested flight numbers to names
			for (int flight = 0; flight < flightsWithStops.size(); flight++) {
				
				for (int i = 0; i < flightsWithStops.get(flight).getCarriers().length; i++) {
					String name = flightsWithStops.get(flight).getCarriers()[i];
					flightsWithStops.get(flight).setCarrierName(i, carriersMap.get(name));

				}

				String origin = placesMap.get(flightsWithStops.get(flight).getOriginStation());
				String destination = placesMap.get(flightsWithStops.get(flight).getDestinationStation());

				flightsWithStops.get(flight).setOriginStation(origin);
				flightsWithStops.get(flight).setDestinationStation(destination);		
			}

			// print main flight with stops
			for (int flight = 0; flight < flights.size(); flight++) {
				System.out.println(flights.get(flight));
				System.out.println("Nested flight: ");
				for (int innerFlight = 0; innerFlight < flights.get(flight).getFlights().size(); innerFlight++) {
					System.out.println(flights.get(flight).getFlights().get(innerFlight));
				}
				System.out.println();
			}		

		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return flights;
	}

	private static String getLocation(FlightSearch search)
			throws MalformedURLException, IOException, ProtocolException, FlightException {
		String originSearch = search.getOrigin().trim();
		String destinationSearch = search.getDestination().trim();
		String departureDateSearch = search.getDepartureDate().trim();
		String returnDateSearch = search.getReturnDate().trim();
		int adultsSearch = search.getAdults();

		String request = "http://partners.api.skyscanner.net/apiservices/pricing/v1.0/";
		URL url = new URL(request);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("charset", "utf-8");


		String urlParameters = "apiKey="+API_KEY+"&country=BG&currency=BGN&locale=en-GB&originplace="
				+ originSearch + "&destinationplace=" + destinationSearch + "&outbounddate=" + departureDateSearch
				+ "&locationschema=Iata&adults=" + adultsSearch;

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;

		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));

		conn.setUseCaches(false);

		try {
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();

		} catch (Exception e) {
			// TODO
			throw new FlightException();
		}

		Map<String, String> map = new HashMap<String, String>();

		for (String header : conn.getHeaderFields().keySet()) {
			if (header != null) {
				for (String value : conn.getHeaderFields().get(header)) {
					map.put(header, value);
				}
			}
		}

		return map.get("Location");	
	}
}
