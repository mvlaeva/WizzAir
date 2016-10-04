package com.wizzair.tests;

import java.sql.SQLException;

import org.junit.Test;

import com.wizzair.DBDAOs.UserDAO;

public class TestUserDAO {
	
	@Test
	public void test() throws SQLException{
		new UserDAO().returnAllUsers();
	}
}
