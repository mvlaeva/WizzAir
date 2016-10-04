package com.wizzair.DBDAOs;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightDAO {
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
}
