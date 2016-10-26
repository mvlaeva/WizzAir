package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonFlight {

	String id;
	String originStation;
	String destinationStation;
	String departure;
	String arrival;
	String duration;
	String[] carriers = new String[0];
	List<JsonFlight> flights;
	String[] stops = new String[0];
	String directionality;
	int[] segmentIds = new int[0];
	double price;
	String ticketSeller;
		
	public JsonFlight(String originStation, String destinationStation, String departure, String arrival,
			String duration, String[] carriers) {
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
		this.carriers = carriers;
	}
	
	public JsonFlight(String id, String originStation, String destinationStation, String departure, String arrival,
			String duration, String[] carriers, String[] stops, String direction, int[] segmentIds ) {
		this(originStation, destinationStation, departure, arrival, duration, carriers);
		this.id = id;		
		this.flights = new ArrayList<JsonFlight>();
		this.stops = stops;
		this.directionality = direction;
		this.segmentIds = segmentIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginStation() {
		return originStation;
	}

	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String[] getCarriers() {
		return carriers;
	}

	public void setCarrierName(int index, String carrier) {
		this.carriers[index] = carrier;
	}

	public List<JsonFlight> getFlights() {
		return this.flights;
	}

	public void addFlights(JsonFlight flight) {
		this.flights.add(flight);
	}

	public String[] getStops() {
		return stops;
	}

	public void setStopName(int index, String stop) {
		this.stops[index] = stop;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int[] getSegmentIds() {
		return segmentIds;
	}

	public void setSegmentIds(int[] segmentIds) {
		this.segmentIds = segmentIds;
	}

	public String getTicketSeller() {
		return ticketSeller;
	}

	public void setTicketSeller(String ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public String getDirectionality() {
		return directionality;
	}

	public void setDirectionality(String directionality) {
		this.directionality = directionality;
	}

	@Override
	public String toString() {
		return "JsonFlight [id=" + id + ", originStation=" + originStation + ", destinationStation="
				+ destinationStation + ", departure=" + departure + ", arrival=" + arrival + ", duration=" + duration
				+ ", carriers=" + Arrays.toString(carriers) + ", flights=" + flights + ", stops="
				+ Arrays.toString(stops) + ", segmentIds=" + Arrays.toString(segmentIds) + ", price=" + price
				+ ", ticketSeller=" + ticketSeller + "]";
	}
}
