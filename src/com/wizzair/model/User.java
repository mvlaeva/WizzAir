package com.wizzair.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wizzair.exceptions.TicketException;
import com.wizzair.exceptions.UserException;

public class User {
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private Gender gender;
	List<Ticket> tickets;
	
	public User(String username, String firstName, String lastName, String email, String phone, String password,
			Gender gender) throws UserException {
		setUsername(username);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		setPassword(password);
		this.gender = gender;
		this.tickets = new ArrayList<Ticket>();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) throws UserException {
		if (Utility.isValidString(username))
			this.username = username;
		else
			throw new UserException("Invalid username!");
	}

	public String getUsername() {
		return username;
	}

	public void setFirstName(String firstName) throws UserException {
		if (Utility.isValidString(firstName))
			this.firstName = firstName;
		else
			throw new UserException("Invalid first name.");
	}

	public void setLastName(String lastName) throws UserException {
		if (Utility.isValidString(lastName))
			this.lastName = lastName;
		else
			throw new UserException("Invalid last name.");
	}

	public void setEmail(String email) throws UserException {
		if (Utility.isValidEmailAddress(email))
			this.email = email;
		else
			throw new UserException("Invalid email address!");
	}

	public void setPhone(String phone) throws UserException {
		if (Utility.isValidPhoneNumber(phone))
			this.phone = phone;
		else
			throw new UserException("Invalid phone number!");
	}

	public void setPassword(String password) throws UserException {
		if (Utility.isPasswordSecure(password))
			this.password = password;
		else
			throw new UserException("Invalid password!");
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public Gender getGender() {
		return gender;
	}
	
	public List<Ticket> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

}
