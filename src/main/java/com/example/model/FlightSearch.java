package com.example.model;

import com.example.model.exceptions.FlightSearchException;

public class FlightSearch {

	private String direction;
	private String origin;
	private String destination;
	private String departureDate;
	private String returnDate;
	private int adults;
	private int children;
	private int stops;

	public FlightSearch(String direction, String origin, String destination, String departureDate, String returnDate, int adults,
			int children, int stops) {
		this.direction = direction;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.adults = adults;
		this.children = children;
		this.stops = stops;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) throws FlightSearchException {
		if (Utility.isValidString(origin))
			this.origin = origin;
		else
			throw new FlightSearchException("Invalid origin!");
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) throws FlightSearchException {
		if (Utility.isValidString(destination))
			this.destination = destination;
		else
			throw new FlightSearchException("Invalid destination!");
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) throws FlightSearchException {
		if (Utility.isValidString(departureDate))
			this.departureDate = departureDate;
		else
			throw new FlightSearchException("Invalid departureDate!");
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) throws FlightSearchException {
		if (Utility.isValidString(returnDate))
			this.returnDate = returnDate;
		else
			throw new FlightSearchException("Invalid returnDate!");
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) throws FlightSearchException {
		if (adults > 0)
			this.adults = adults;
		else
			throw new FlightSearchException("Invalid count of adults!");
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) throws FlightSearchException {
		if (stops > 0)
			this.stops = stops;
		else
			throw new FlightSearchException("Invalid count of stops!");
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
