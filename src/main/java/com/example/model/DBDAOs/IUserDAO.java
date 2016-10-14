package com.example.model.DBDAOs;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Flight;
import com.example.model.IUser;
import com.example.model.Passanger;
import com.example.model.Ticket;
import com.example.model.User;
import com.example.model.exceptions.UserDAOException;
import com.example.model.exceptions.UserException;

public interface IUserDAO {

	List<Flight> viewBoughtTickets(User user) throws UserDAOException, SQLException;

	void changePassword(User user, String newPassword) throws UserException, SQLException;

	void changeEmail(User user, String newEmail) throws UserException, SQLException;

	void changePhone(User user, String newPhone) throws UserException, SQLException;

	void buyTicket(Ticket ticket, User user, List<Passanger> passangers) throws UserDAOException, SQLException;

	void registerUser(User user) throws SQLException, UserException, UserDAOException;

	IUser login(User user) throws Exception;

	User getRecentInfo(User user) throws SQLException, UserException;
	
	

	// void buyTicket(Ticket ticket, User user, Passanger passangers) throws
	// UserDAOException, SQLException;

}