package com.wizzair.model;

import java.util.ArrayList;

import com.wizzair.exceptions.TicketException;
import com.wizzair.exceptions.UserException;

public interface IUser {

	void addTickets(ArrayList<Ticket> tickets) throws TicketException;

	void removeAllTickets();

	void removeTicket(int currentNumber) throws TicketException;

	void changePassword(String newPassword) throws UserException;

	void changeEmail(String newEmail) throws UserException;

	void changePhone(String newPhone) throws UserException;

	void showBoughtTickets();

}