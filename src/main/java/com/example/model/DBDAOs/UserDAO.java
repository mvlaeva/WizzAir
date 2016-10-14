package com.example.model.DBDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Flight;
import com.example.model.Gender;
import com.example.model.IUser;
import com.example.model.Passanger;
import com.example.model.Ticket;
import com.example.model.User;
import com.example.model.exceptions.UserDAOException;
import com.example.model.exceptions.UserException;

public class UserDAO implements IUserDAO {
	private static final String INSERT_INTO_FLIGHTS_HAS_PASSANGERS_SQL = "INSERT INTO flights_has_passangers VALUES (?,?,?)";
	private static final String INSERT_INTO_SEATS_SQL = "INSERT INTO seats VALUES (null,?,?)";
	private static final String INSERT_INTO_PASSANGERS_SQL = "INSERT INTO passangers VALUES (null, ?, ?)";
	private static final String INSERT_INTO_USERS_HAS_FLIGHTS_SQL = "INSERT INTO users_has_flights VALUES (?,?)";
	private static final String INSERT_INTO_FLIGHTS_SQL = "INSERT INTO flights VALUES (null, ?, ?, ?)";
	private static final String SELECT_PROFILE_DATA_SQL = "SELECT gender, phone, email, first_name, last_name FROM users;";
	private static final String SELECT_USERNAME_PASSWORD_SQL = "SELECT username, password FROM users;";
	private static final String RETURN_ALL_USERS_SQL = "SELECT id, username, first_name, last_name, email, password FROM users;";
	private static final String INSERT_NEW_USER_SQL = "INSERT INTO users VALUES (null, ?, ?, ?, md5(?), ?, ?, ?);";

	Connection connection = DBConnection.getInstance().getConnection();

	@Override
	public List<Flight> viewBoughtTickets(User user) throws UserDAOException, SQLException {
		List<Flight> flights = new ArrayList<Flight>();
		if (user != null) {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + "FROM users u " + "left outer join users_has_flights y "
					+ "ON (u.id = y.users_id) " + "JOIN flights f " + "ON (y.flights_id = f.id)");
			
			while (rs.next()) {
				String origin = rs.getString("origin");
				String destination = rs.getString("destination");
				String sample = rs.getString("date_and_time");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateAndTime = LocalDate.parse(sample, formatter);
				System.out.println("sample: " + sample);
				System.out.println(LocalDate.parse(sample, formatter).toString());

				flights.add(new Flight(origin, destination, dateAndTime));
			}
			return flights;
			
		} else
			throw new UserDAOException("Invalid user input!");
	}

	@Override
	public void changePassword(User user, String newPassword) throws UserException, SQLException {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT id FROM users WHERE username='" + user.getUsername() + "';");

		rs.next();
		int id = rs.getInt(1);

		System.out.println("id: " + id);

		System.out.println("new pass: " + newPassword);

		st = connection.createStatement();
		st.executeUpdate("UPDATE users SET password=md5('" + newPassword + "') WHERE id=" + id + ";");

		user.changePassword(newPassword);
	}

	@Override
	public void changeEmail(User user, String newEmail) throws UserException, SQLException {

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT id FROM users WHERE username='" + user.getUsername() + "';");

		rs.next();
		int id = rs.getInt(1);

		connection.createStatement().executeUpdate("UPDATE users SET email='" + newEmail + "' WHERE id='" + id + "';");

		user.changeEmail(newEmail);
	}

	@Override
	public void changePhone(User user, String newPhone) throws UserException, SQLException {

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT id FROM users WHERE username='" + user.getUsername() + "';");

		rs.next();
		int id = rs.getInt(1);

		connection.createStatement().executeUpdate("UPDATE users SET phone='" + newPhone + "' WHERE id='" + id + "';");

		user.changePhone(newPhone);
	}

	@Override
	public void buyTicket(Ticket ticket, User user, List<Passanger> passangers) throws UserDAOException, SQLException {
		if (user != null) {

			try {
				connection.setAutoCommit(false);

				/*
				 * Insert user into users
				 */
				PreparedStatement ps = connection.prepareStatement(INSERT_INTO_FLIGHTS_SQL,
						Statement.RETURN_GENERATED_KEYS);

				System.out.println("buyTicket: ticket.getFlight().getOrigin(): " + ticket.getFlight().getOrigin());

				ps.setString(1, ticket.getFlight().getOrigin());
				ps.setString(2, ticket.getFlight().getDestination());
				ps.setString(3, ticket.getFlight().getDateAndTime().toString());

				System.out.println("insert into flight successful!");

				ps.executeUpdate();

				/*
				 * Takes user id
				 */
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				int ticketId = rs.getInt(1);
				System.out.println("ticketid: " + ticketId);

				Statement st = connection.createStatement();
				rs = st.executeQuery("select id from users where username='" + user.getUsername() + "'");
				rs.next();
				int userId = rs.getInt(1);
				System.out.println("userid: " + userId);

				ps = connection.prepareStatement(INSERT_INTO_USERS_HAS_FLIGHTS_SQL);
				ps.setInt(1, userId);
				ps.setInt(2, ticketId);
				ps.executeUpdate();
				System.out.println("insert into mapping successful!");

				List<Integer> passangerIds = new ArrayList<Integer>();
				List<Integer> seatIds = new ArrayList<Integer>();

				for (Passanger pas : passangers) {
					ps = connection.prepareStatement(INSERT_INTO_PASSANGERS_SQL, Statement.RETURN_GENERATED_KEYS);

					ps.setString(1, pas.getFirstName());
					ps.setString(2, pas.getLastName());

					ps.executeUpdate();
					rs = ps.getGeneratedKeys();
					rs.next();
					int pasid = rs.getInt(1);
					System.out.println("pasid: " + pasid);

					passangerIds.add(new Integer(pasid));

					ps = connection.prepareStatement(INSERT_INTO_SEATS_SQL, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, pas.getSeat().charAt(0));
					ps.setString(2, pas.getSeat().substring(1, 2));
					System.out.println("pas.getSeat().substring(1, 2) : " + pas.getSeat().substring(1, 2));
					ps.executeUpdate();

					rs = ps.getGeneratedKeys();
					rs.next();
					int seatid = rs.getInt(1);
					seatIds.add(seatid);
					System.out.println("seatid: " + seatid);

					ps = connection.prepareStatement(INSERT_INTO_FLIGHTS_HAS_PASSANGERS_SQL);
					System.out.println(ticketId);
					ps.setInt(1, ticketId);
					ps.setInt(2, pasid);
					ps.setInt(3, seatid);
					ps.executeUpdate();
					System.out.println("inserting into flights_has_passangers successful!");

				}
				System.out.println("passangers and seats and flights_has_passangers done!");

				connection.commit();
				// TODO test if exception breaks web applicatin
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} else
			throw new UserDAOException("Bad user input.");
	}

	@Override
	public void registerUser(User user) throws SQLException, UserException, UserDAOException {
		if (user != null) {
			if (userExists(user)) {
				throw new UserDAOException("User already exists!");
			}

			PreparedStatement ps = connection.prepareStatement(INSERT_NEW_USER_SQL);

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getGender().toString());

			ps.executeUpdate();

		} else
			throw new UserDAOException("Something went wrong. Please try again later!");
	}

	private boolean userExists(User user) throws SQLException, UserException {
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery(SELECT_USERNAME_PASSWORD_SQL);
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

	@Override
	public IUser login(User user) throws Exception {
		if (userExistsWithThisPass(user)) {
			setUserFields(user);
			return user;
		} else
			throw new UserException("Username/password mismatch!");
	}

	private boolean userExistsWithThisPass(User user) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT username, password from users where username='"
				+ user.getUsername() + "' AND password=md5('" + user.getPassword() + "');");
		while (resultSet.next()) {
			String username = resultSet.getString("username");
			if (username.equals(user.getUsername()))
				return true;
		}
		return false;
	}

	private IUser setUserFields(User user) throws UserException, SQLException {
		if (user != null) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_PROFILE_DATA_SQL);

			while (rs.next()) {
				String phone = rs.getString("phone");
				Gender gender = rs.getString("gender").equals(Gender.MALE) ? Gender.MALE : Gender.FEMALE;
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				user.setGender(gender);
				user.setPhone(phone);
				user.setEmail(email);
				user.setFirstName(firstName);
				user.setLastName(lastName);
			}

			return user;

		} else
			throw new UserException("User doesn't exist!");
	}

	public User getRecentInfo(User user) throws SQLException, UserException {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username='" + user.getUsername() + "'");

		rs.next();

		String email = rs.getString("email");
		String phone = rs.getString("phone");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		Gender gender = rs.getString("gender").equals(Gender.MALE) ? Gender.MALE : Gender.FEMALE;

		return new User(user.getUsername(), firstName, lastName, email, phone, user.getPassword(), gender);

	}
}