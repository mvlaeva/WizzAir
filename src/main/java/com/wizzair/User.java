package com.wizzair;

import java.util.ArrayList;
import java.util.List;

import exceptions.TicketException;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private Gender gender;
	List<Ticket> tickets;
	// TODO DEPENDENCIES

	public User(String firstName, String lastName, String email, String phone, String password, Gender gender,
			List<Ticket> tickets) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.tickets = new ArrayList<Ticket>();
	}

	public void setFirstName(String firstName) throws UserException {
		if (Utility.isValidString(firstName))
			this.firstName = firstName;
		throw new UserException("Invalid first name.");
	}

	public void setLastName(String lastName) throws UserException {
		if (Utility.isValidString(lastName))
			this.lastName = lastName;
		throw new UserException("Invalid last name.");
	}

	//TODO EMAIL
	public void setEmail(String email) {
		this.email = email;
	}

	//TODO PHONE
	public void setPhone(String phone) {
		this.phone = phone;
	}

	//TODO secure pass
	public void setPassword(String password) {
		this.password = password;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void addTicket(Ticket ticket) throws TicketException {
		if (ticket != null)
			this.tickets.add(ticket);
		else
			throw new TicketException("Ticket is null.");
	}
}
