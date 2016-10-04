package com.wizzair.DBDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	Connection connection = DBConnection.getInstance().getConnection();

	public void returnAllUsers() throws SQLException {
		try {
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

				System.out.println("User with ID: " + id);
				System.out.println("username: " + username);
				System.out.println("Name: " + firstName + " " + lastName);
				System.out.println("Email: " + email);
				System.out.println("Password: " + password);
				System.out.println();
				
				resultSet.close();
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}