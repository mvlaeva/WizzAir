package com.wizzair.model;

public class JsonFlight {
	
	String id;
	String originStation;
	String destinationStation;
	String departure;
	String arrival;
	String duration;
	String carrier;
	double price;
	
	public JsonFlight(String id, String originStation, String destinationStation, String departure, String arrival,
			String duration, String carrier) {
		this.id = id;
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
		this.carrier = carrier;
	}

	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOriginStation() {
		return originStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public String getCarrier() {
		return carrier;
	}

	public double getPrice() {
		return price;
	}

	public String getId() {
		return id;
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

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "JsonFlight [id=" + id + ", originStation=" + originStation + ", destinationStation="
				+ destinationStation + ", departure=" + departure + ", arrival=" + arrival + ", duration=" + duration
				+ ", carrier=" + carrier + ", price=" + price + "]";
	}

}
