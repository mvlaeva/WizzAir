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
import java.util.List;
import java.util.Map;

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

	public static List<JsonFlight> getFlights(FlightSearch search) throws Exception {

		String location = getLocation(search);

		return getFlightsQuery(location);
	}

	private static List<JsonFlight> getFlightsQuery(String location) throws Exception {
		String request2 = location + "?apiKey=" + API_KEY + "&includecarriers=W6";

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
		Map<String, HashMap<String, Double>> flightIds = new HashMap<String, HashMap<String, Double>>();
		Map<String, String> carriersMap = new HashMap<String, String>();
		Map<String, String> agentsMap = new HashMap<String, String>();
		Map<String, String> placesMap = new HashMap<String, String>();

		try {
			System.out.println(response);
					
			JsonElement element = new JsonParser().parse(response.toString());
			
			if (element.isJsonNull())
				return getFlightsQuery(location);
			
			object = (JsonObject) element;

			if (object.get("Status").getAsString().equals("UpdatesPending"))
				return getFlightsQuery(location);

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

			JsonArray legs = object.getAsJsonArray("Legs");

			for (int i = 0; i < legs.size(); i++) {
				JsonObject flight = legs.get(i).getAsJsonObject();

				String id = flight.get("Id").getAsString();
				String originStation = flight.get("OriginStation").getAsString();
				String destinationStation = flight.get("DestinationStation").getAsString();
				String departure = flight.get("Departure").getAsString();
				String arrival = flight.get("Arrival").getAsString();
				String duration = flight.get("Duration").getAsString();
				String carrier = flight.get("Carriers").getAsString();

				flights.add(
						new JsonFlight(id, originStation, destinationStation, departure, arrival, duration, carrier));

			}

			JsonArray carriers = object.getAsJsonArray("Carriers");

			for (int number = 0; number < carriers.size(); number++) {
				JsonObject jsonCarrier = carriers.get(number).getAsJsonObject();

				String id = jsonCarrier.get("Id").getAsString();
				String name = jsonCarrier.get("Name").getAsString();
				carriersMap.put(id, name);
			}

			JsonArray agents = object.getAsJsonArray("Agents");

			for (int index = 0; index < agents.size(); index++) {

				JsonObject jsonAgent = agents.get(index).getAsJsonObject();

				String id = jsonAgent.get("Id").getAsString();
				String name = jsonAgent.get("Name").getAsString();
				agentsMap.put(name, id);
			}

			JsonArray places = object.getAsJsonArray("Places");

			for (int index = 0; index < places.size(); index++) {

				JsonObject jsonPlace = places.get(index).getAsJsonObject();

				String id = jsonPlace.get("Id").getAsString();
				String name = jsonPlace.get("Name").getAsString();
				placesMap.put(id, name);
			}

			for (int flight = 0; flight < flights.size(); flight++) {

				String flightId = flights.get(flight).getId();
				HashMap<String, Double> agentAndPrice = flightIds.get(flightId);

				String agentId = agentsMap.get("Wizz Air");
				double price = agentAndPrice.get(agentId);
				String carrierName = carriersMap.get(flights.get(flight).getCarrier());
				String origin = placesMap.get(flights.get(flight).getOriginStation());
				String destination = placesMap.get(flights.get(flight).getDestinationStation());

				flights.get(flight).setPrice(price);
				flights.get(flight).setCarrier(carrierName);
				flights.get(flight).setOriginStation(origin);
				flights.get(flight).setDestinationStation(destination);

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
		String adultsSearch = search.getAdults().trim();

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
