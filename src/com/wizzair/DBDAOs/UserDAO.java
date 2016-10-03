package com.wizzair.DBDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	private static final String DB_SCHEMA = "mydb";
	private static final String DB_PORT = "3306";
	private static final String DB_HOST = "localhost";
	private static final String DB_PASSWORD = "admin";
	private static final String DB_USERNAME = "root";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_SCHEMA+ "?autoReconnect=true&useSSL=false",
					DB_USERNAME, DB_PASSWORD);

			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("SELECT id, username, first_name, last_name, email, password FROM users;");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				System.out.println("User with ID " + id);
				System.out.println("username: " + username);
				System.out.println("Name: " + firstName + " " + lastName);
				System.out.println("Email :" + email);
				System.out.println("Password: " + password);
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}