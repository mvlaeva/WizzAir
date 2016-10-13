package com.wizzair.model;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.wizzair.DBDAOs.DBConnection;
import com.wizzair.DBDAOs.UserDAO;;

public abstract class Utility {

	private static final int COUNT_DIGITS_PHONE_NUMBER_STARTING_WITH_359 = 13;
	private static final int COUNT_DIGITS_PHONE_NUMBER = 10;

	public static boolean isValidString(String string) {
		if (string != null && string.trim().length() > 0) {
			return true;
		}
		return false;
	}

	public static boolean isValidEmailAddress(final String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	/***
	 * 
	 * @param phoneNumber
	 * @return true if phone number contains 10 or 13 numbers; Valid format is:
	 *         08XXXXXXXX or +3598XXXXXXXX
	 * @throws ProfileException
	 */
	public static boolean isValidPhoneNumber(final String phoneNumber) {
		if (phoneNumber == null)
			return false;

		if (((phoneNumber.trim().startsWith("+3598")
				&& phoneNumber.length() == COUNT_DIGITS_PHONE_NUMBER_STARTING_WITH_359)
				|| (phoneNumber.trim().startsWith("08")) && phoneNumber.length() == COUNT_DIGITS_PHONE_NUMBER)) {
			return true;
		}
		return false;
	}

	public static boolean isPasswordSecure(final String password) {
		boolean hasLowerCase = false;
		boolean hasUpperCase = false;
		boolean hasDigit = false;
		if (password == null || password.length() <= 6) {
			return false;
		}
		for (int index = 0; index < password.length(); ++index) {
			if (password.charAt(index) >= 'a' && password.charAt(index) <= 'z')
				hasLowerCase = true;
			if (password.charAt(index) >= 'A' && password.charAt(index) <= 'Z')
				hasUpperCase = true;
			if (password.charAt(index) >= '0' && password.charAt(index) <= '9')
				hasDigit = true;
		}
		if (hasLowerCase && hasUpperCase && hasDigit) {
			return true;
		}
		return false;
	}

	public static boolean passwordMatches(User user) throws Exception {
		Connection connection = (Connection) new DBConnection().getInstance().getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT username, password FROM users;");
		MessageDigest md = MessageDigest.getInstance("MD5");

		while (rs.next()) {
			if (rs.getString("username").equals(user.getUsername())
					&& rs.getString("password").equals(md.digest((user.getPassword().getBytes()))))
				return true;
		}

		return false;
	}

}
