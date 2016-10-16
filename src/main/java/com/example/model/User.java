package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.model.exceptions.TicketException;
import com.example.model.exceptions.UserException;

public class User implements IUser {
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private Gender gender;
	List<Ticket> tickets;
	List<Flight> boughtTickets;

	public User(String username, String firstName, String lastName, String email, String phone, String password,
			Gender gender) throws UserException {
		setUsername(username);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		System.out.println(password);
		setPassword(password);
		this.gender = gender;
		this.tickets = new ArrayList<Ticket>();
		this.boughtTickets = new ArrayList<Flight>();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void addTickets(ArrayList<Ticket> tickets) throws TicketException {
		if (tickets != null)
			for (Ticket ticket : tickets) {
				if (ticket != null)
					this.tickets.add(ticket);
			}
		else
			throw new TicketException("Tickets null.");
	}

	@Override
	public void removeAllTickets() {
		if (tickets != null)
			for (Ticket ticket : tickets) {
				ticket = null;
			}
	}

	@Override
	public void removeTicket(int currentNumber) throws TicketException {
		if (tickets.get(currentNumber) != null) {
			tickets.remove(currentNumber);
		} else
			throw new TicketException("Bad ticket number.");
	}

	@Override
	public void changePassword(String newPassword) throws UserException {
		setPassword(newPassword);
	}

	@Override
	public void showBoughtTickets() {
		for (Ticket ticket : tickets) {
			System.out.println(ticket.getFlight().getOriginStation() + "\n" + ticket.getFlight().getDestinationStation() + "\n"
					+ ticket.getFlight().getDeparture());
		}
	}

	@Override
	public void changeEmail(String newEmail) throws UserException {
		setEmail(newEmail);
	}

	@Override
	public void changePhone(String newPhone) throws UserException {
		setPhone(newPhone);
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

	public List<Flight> getBoughtTickets() {
		return boughtTickets;
	}
}
