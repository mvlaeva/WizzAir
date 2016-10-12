package com.wizzair.tests;

import org.junit.Test;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.model.Gender;
import com.wizzair.model.User;

public class TestUserDAO {

	@Test
	public void test() throws Exception {
		new UserDAO().returnAllUsers();

		//new UserDAO().registerUser(new User("pesho", "petur", "petrovV1", "pesho@abv.bg", "0883343440", "petrovV1", Gender.MALE));

		new UserDAO().login(new User("pesho", "petrovV1"));
	}
}