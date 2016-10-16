package com.example.model;

import java.time.LocalDate;

import com.example.model.exceptions.PassangerException;
import com.example.model.exceptions.TicketException;

public class Ticket {
	private JsonFlight flight;
	private Passanger passanger;
	private String flightNumber;
	private String confirmationCode;
	private LocalDate gateClose;
	private LocalDate departureTime;

	public Ticket(Passanger passanger, String flightNumber, String confirmationCode, LocalDate departureTime) {
		this.passanger = passanger;
		this.flightNumber = flightNumber;
		this.confirmationCode = confirmationCode;
		this.departureTime = departureTime;
	}

	public void setFlight(JsonFlight flight) throws TicketException {
		if (flight != null)
			this.flight = flight;
		else
			throw new TicketException("Your flight contains invalid data.");
	}

	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) throws PassangerException {
		if (passanger != null)
			this.passanger = passanger;
		else
			throw new PassangerException("Invalid passanger.");
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) throws TicketException {
		if (flightNumber != null)
			this.flightNumber = flightNumber;
		else
			throw new TicketException("Invalid flight number.");
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) throws TicketException {
		if (confirmationCode != null)
			this.confirmationCode = confirmationCode;
		else
			throw new TicketException("Invalid confirmation code.");
	}

	public LocalDate getGateClose() {
		return gateClose;
	}

	public void setGateClose(LocalDate gateClose) {
		this.gateClose = gateClose;
	}

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

	public JsonFlight getFlight() {
		return flight;
	}

	@Override
	public String toString() {
		return "Ticket [flight=" + flight + ", passanger=" + passanger + ", flightNumber=" + flightNumber
				+ ", confirmationCode=" + confirmationCode + ", gateClose=" + gateClose + ", departureTime="
				+ departureTime + "]";
	}

}
