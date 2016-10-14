package com.example.model;

import java.util.ArrayList;

import com.example.model.exceptions.TicketException;
import com.example.model.exceptions.UserException;

public interface IUser {

	void addTickets(ArrayList<Ticket> tickets) throws TicketException;

	//TODO
	void removeAllTickets();

	void removeTicket(int currentNumber) throws TicketException;

	void changePassword(String newPassword) throws UserException;

	void changeEmail(String newEmail) throws UserException;

	void changePhone(String newPhone) throws UserException;

	void showBoughtTickets();

}