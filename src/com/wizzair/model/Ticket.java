package com.wizzair.model;

import java.time.LocalDate;

import com.wizzair.exceptions.PassangerException;
import com.wizzair.exceptions.TicketException;

public class Ticket {
	private Passanger passanger;
	private String flightNumber;
	private String confirmationCode;
	private LocalDate gateClose;
	private LocalDate departureTime;

	public Ticket(Passanger passanger, String flightNumber, String confirmationCode, LocalDate gateClose,
			LocalDate departureTime) {
		this.passanger = passanger;
		this.flightNumber = flightNumber;
		this.confirmationCode = confirmationCode;
		this.gateClose = gateClose;
		this.departureTime = departureTime;
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

}
