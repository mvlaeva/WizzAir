package com.wizzair.DBDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wizzair.exceptions.FlightDAOException;
import com.wizzair.exceptions.UserDAOException;
import com.wizzair.exceptions.UserException;
import com.wizzair.model.User;
import com.wizzair.model.Utility;

public class UserDAO {
	private static final String SELECT_ALL_USERS_SQL = "SELECT username FROM users";
	private static final String RETURN_ALL_USERS_SQL = "SELECT id, username, first_name, last_name, email, password FROM users;";
	private static final String INSERT_NEW_USER_SQL = "INSERT INTO users VALUES (null, null, null,  ?, md5(?), null, ?);";

	Connection connection = DBConnection.getInstance().getConnection();

	public User registerUser(User user) throws SQLException, UserException, UserDAOException {
		if (user != null) {
			if (userExists(user))
				throw new UserException("User already exists!");

			PreparedStatement ps = connection.prepareStatement(INSERT_NEW_USER_SQL);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());

			ps.executeUpdate();

			System.out.println("Successful registration!");
			
			return user;

		} else
			throw new UserDAOException("Something went wrong. Please try again later!");
	}

	private boolean userExists(User user) throws SQLException, UserException {
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("select username, password from users");
		while (resultSet.next()) {
			String username = resultSet.getString("username");
			if (username.equals(user.getUsername()))
				return true;
		}
		return false;
	}

	public void returnAllUsers() throws SQLException, UserException {
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
			throw new UserException("Something went wrong! Try again later.");
		}
	}

	public User login(User user) throws Exception {
		if (userExists(user) && Utility.passwordMatches(user)) {
			setUserFields(user);
			return user;
		} else
			throw new UserException("Username/password mismatch!");
	}

	private User setUserFields(User user) throws UserException, SQLException {
		if (user != null) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT first_name,last_name, email FROM users;");

			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				user.setEmail(email);
				user.setFirstName(firstName);
				user.setLastName(lastName);
			}

			return user;

		} else
			throw new UserException("User doesn't exist!");
	}
}