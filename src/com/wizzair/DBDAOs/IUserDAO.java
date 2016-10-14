package com.wizzair.DBDAOs;

import java.sql.SQLException;
import java.util.List;

import com.wizzair.exceptions.UserDAOException;
import com.wizzair.exceptions.UserException;
import com.wizzair.model.Flight;
import com.wizzair.model.IUser;
import com.wizzair.model.Passanger;
import com.wizzair.model.Ticket;
import com.wizzair.model.User;

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