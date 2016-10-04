package com.wizzair.DBDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wizzair.exceptions.UserException;
import com.wizzair.model.User;

public class UserDAO {
	private static final String RETURN_ALL_USERS = "SELECT id, username, first_name, last_name, email, password FROM users;";
	Connection connection = DBConnection.getInstance().getConnection();

	public void registerUser(User user) throws SQLException, UserException {
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("select username from users");
		while (resultSet.next()) {
			if (resultSet.getString("username").equals(user.getUsername()))
				throw new UserException("User already exists!");
		}

		stmt = connection.createStatement();

		stmt.executeUpdate(
				"INSERT INTO `mydb`.`users` ( `first_name`, `last_name`, `username`, `password`, `email`) VALUES ( '"
						+ user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getUsername() + "', '"
						+ user.getPassword() + "', '" + user.getEmail() + "');");

	}

	public void returnAllUsers() throws SQLException {
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(RETURN_ALL_USERS);

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

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}