package com.example.model.APIConnection;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.example.model.JsonFlight;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiFromTextDAO {

	private static final String COMPANY_CODE = "1914";
	private static final String COMPANY_NAME = "Wizz Air";

	public static List<JsonFlight> getFlights() throws Exception {

		List<JsonFlight> flights = new ArrayList<JsonFlight>();
		Map<Integer, JsonFlight> flightsWithStops = new HashMap<Integer, JsonFlight>();
		Map<String, HashMap<String, Double>> flightIds = new HashMap<String, HashMap<String, Double>>();
		Map<String, String> carriersMap = new HashMap<String, String>();
		Map<String, String> agentsMap = new HashMap<String, String>();
		Map<String, String> placesMap = new HashMap<String, String>();

		try {

			// all carriers with flights
			
			JsonObject object = (JsonObject) new JsonParser().parse(new FileReader("D:\\workspaceSpring\\WizzAir\\src\\main\\webapp\\static\\pdf\\json-with-return.txt"));
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

				// add only flights where Wizz Air takes part
				/*
				 * if (!(carriersSet.contains(COMPANY_CODE))) { continue; }
				 */

				JsonArray stopsArr = flight.get("Stops").getAsJsonArray();
				String[] stops = new String[stopsArr.size()];
				for (int stop = 0; stop < stopsArr.size(); stop++) {
					stops[stop] = stopsArr.get(stop).getAsString();
				}
				
				String directionality = flight.get("Directionality").getAsString();
				
				JsonArray segmentIdsArr = flight.get("SegmentIds").getAsJsonArray();
				int[] segmentIds = new int[segmentIdsArr.size()];
				for (int index = 0; index < segmentIdsArr.size(); index++) {
					segmentIds[index] = segmentIdsArr.get(index).getAsInt();
				}

				flights.add(new JsonFlight(id, originStation, destinationStation, departure, arrival, duration, carrier,
						stops, directionality,segmentIds));

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

			// contains places(origin, destination) where to an id correspond a
			// name
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
				// get the id for COMPANY_NAME
				String agentNumber = agentsMap.get(COMPANY_NAME);
				for (Entry<String, Double> agent : agentAndPrice.entrySet()) {

					// check if the COMPANY_NAME had set a price, else choose
					// the lowest one
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

				// if this is a direct flight - lenght = 1
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}	
}
