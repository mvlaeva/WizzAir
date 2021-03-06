package com.wizzair.DBDAOs;

import java.time.LocalDate;

import com.wizzair.exceptions.FlightDAOException;
import com.wizzair.exceptions.FlightException;
import com.wizzair.model.Flight;
import com.wizzair.model.User;
import com.wizzair.model.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightDAO {
	private static final String INSERT_INTO_MAPPING_SQL = "INSERT INTO users_has_flights VALUES (?,?);";
	private static final String INSERT_FLIGHTS_SQL = "INSERT INTO flights VALUES (null, ?, ?, ?);";
	Connection connection = DBConnection.getInstance().getConnection();

	public void showFlights(String origin, String destination, LocalDate dateAndTime) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM flights f WHERE f.origin='" + origin
					+ "' and f.destination='" + destination + "' and f.date_and_time='" + dateAndTime + "'");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String from = resultSet.getString("origin");
				String to = resultSet.getString("destination");
				String time = resultSet.getString("date_and_time");

				System.out.println("Flight ID: " + id);
				System.out.println("Origin: " + from);
				System.out.println("Destination: " + to);
				System.out.println("Date and time: " + time);
				System.out.println();

				resultSet.close();
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("No such flight has been found. Please try our services later, please!");
		}
	}

	public void buyFlight(User user, Flight flight) throws SQLException, FlightException, FlightDAOException {
		if (user != null && flight != null) {

			try {
				connection.setAutoCommit(false);

				int newFlightID = 0;

				if (isNotInserted(flight)) {
					PreparedStatement ps = connection.prepareStatement(INSERT_FLIGHTS_SQL,
							Statement.RETURN_GENERATED_KEYS);
					if (Utility.isValidString(flight.getOrigin()))
						ps.setString(1, flight.getOrigin());
					if (Utility.isValidString(flight.getDestination()))
						ps.setString(2, flight.getDestination());
					if (Utility.isValidString(flight.getDateAndTime().toString()))
						ps.setString(3, flight.getDateAndTime().toString());

					ResultSet rs = ps.getGeneratedKeys();
					rs.next();
					newFlightID = rs.getInt(1);

				} else { // matching
					newFlightID = getFlightId(flight);
				}

				PreparedStatement prepst = connection.prepareStatement(INSERT_INTO_MAPPING_SQL);
				prepst.setInt(1, getUserID(user));
				prepst.setInt(2, newFlightID);

				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw new FlightDAOException("You cannot make a purchase at this time! Please try again later!");
			}
		}
	}

	private int getUserID(User user) throws SQLException {
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE username='" + user.getUsername() + "';");

		rs.next();
		return rs.getInt(1);
	}

	private int getFlightId(Flight flight) throws SQLException, FlightException {
		if (flight != null) {
			Statement stmt = connection.createStatement();

			if (Utility.isValidString(flight.getOrigin()) && Utility.isValidString(flight.getDestination())
					&& Utility.isValidString(flight.getDateAndTime().toString())) {
				ResultSet rs = stmt.executeQuery("SELECT id FROM flights WHERE origin='" + flight.getOrigin()
						+ "' AND destination='" + flight.getDestination() + " AND date_and_time='"
						+ flight.getDateAndTime().toString() + "'';");

				rs.next();
				return rs.getInt(1);
			}
		}
		throw new FlightException("Wrong flight info was submited!");
	}

	private boolean isNotInserted(Flight flight) throws SQLException, FlightException {
		if (flight != null) {
			Statement stmt = connection.createStatement();

			if (Utility.isValidString(flight.getOrigin()) && Utility.isValidString(flight.getDestination())
					&& Utility.isValidString(flight.getDateAndTime().toString())) {
				ResultSet rs = stmt.executeQuery("SELECT id FROM flights WHERE origin='" + flight.getOrigin()
						+ "' AND destination='" + flight.getDestination() + " AND date_and_time='"
						+ flight.getDateAndTime().toString() + "'';");

				/*
				 * Returns:true if the new current row is valid; false if there
				 * are no more rows
				 */
				return rs.next();
			} else
				throw new FlightException("Wrong flight info was submited!");
		}
		return false;
	}
}
