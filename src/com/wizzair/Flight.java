package com.wizzair;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Flight {
	
	private String origin;
	private String destination;
	LocalDate dateAndTime;
	List<Passanger> passangers;
	Map<String ,Boolean> seats;
	
	public Flight(String origin, String destination, LocalDate dateAndTime, List<Passanger> passangers,
			Map<String, Boolean> seats) {
		this.origin = origin;
		this.destination = destination;
		this.dateAndTime = dateAndTime;
		this.passangers = passangers;
		this.seats = seats;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDate dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public List<Passanger> getPassangers() {
		return passangers;
	}

	public void setPassangers(List<Passanger> passangers) {
		this.passangers = passangers;
	}

	public Map<String, Boolean> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, Boolean> seats) {
		this.seats = seats;
	}

	
	
}
