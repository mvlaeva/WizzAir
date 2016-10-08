package com.wizzair.DBDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wizzair.exceptions.FlightDAOException;
import com.wizzair.exceptions.UserException;
import com.wizzair.model.User;

public class UserDAO {
	private static final String SELECT_ALL_USERS_SQL = "SELECT username FROM users";
	private static final String RETURN_ALL_USERS_SQL = "SELECT id, username, first_name, last_name, email, password FROM users;";
	private static final String INSERT_NEW_USER_SQL = "INSERT INTO users VALUES (null, null, null,  ?, md5(?), null, ?);";

	Connection connection = DBConnection.getInstance().getConnection();

	public void registerUser(User user) throws SQLException, UserException, FlightDAOException {
		if (user != null) {
			if (userExists(user))
				throw new UserException("User already exists!");

			PreparedStatement ps = connection.prepareStatement("INSERT_NEW_USER_SQL");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());

			ps.executeUpdate();

			System.out.println("Successful registration!");

		} else
			throw new FlightDAOException("Something went wrong. Please try again later!");
	}

	private boolean userExists(User user) throws SQLException, UserException {
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery(SELECT_ALL_USERS_SQL);
		while (resultSet.next()) {
			if (resultSet.getString("username").equals(user.getUsername()))
				return true;
		}
		return false;
	}

	public void returnAllUsers() throws SQLException {
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(RETURN_ALL_USERS_SQL);

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

	public boolean login(User user) throws Exception {
		if (userExists(user) && passwordMatches(user))
			return true;
		else
			return false;
	}

	private boolean passwordMatches(User user) throws Exception {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT username, password FROM users;");

		while (rs.next()) {
			if (rs.getString("username").equals(user.getUsername())
					&& rs.getString("password").equals(user.getPassword()))
				return true;
		}
		return false;
	}
}