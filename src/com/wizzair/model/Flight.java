package com.wizzair.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wizzair.exceptions.FlightException;

public class Flight {

	private String origin;
	private String destination;
	LocalDate dateAndTime;
	List<Passanger> passangers;
	Map<String, Boolean> seats;

	public Flight(String origin, String destination, LocalDate dateAndTime) {
		this.origin = origin;
		this.destination = destination;
		this.dateAndTime = dateAndTime;
		this.passangers = new ArrayList<Passanger>();
		this.seats = new HashMap<String, Boolean>();
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) throws FlightException {
		if (Utility.isValidString(origin))
			this.origin = origin;
		else
			throw new FlightException("Invalid origin!");
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) throws FlightException {
		if (Utility.isValidString(destination))
			this.destination = destination;
		else
			throw new FlightException("Invalid destination!");
	}

	public LocalDate getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDate dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public List<Passanger> getPassangers() {
		return Collections.unmodifiableList(passangers);
	}

	public void setPassangers(List<Passanger> passangers) {
		this.passangers = passangers;
	}

	public Map<String, Boolean> getSeats() {
		return Collections.unmodifiableMap(seats);
	}

	public void setSeats(Map<String, Boolean> seats) {
		this.seats = seats;
	}

}
