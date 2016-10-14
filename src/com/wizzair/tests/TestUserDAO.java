package com.wizzair.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.model.CabinBaggage;
import com.wizzair.model.ChechedInBaggage;
import com.wizzair.model.Flight;
import com.wizzair.model.Gender;
import com.wizzair.model.Passanger;
import com.wizzair.model.Ticket;
import com.wizzair.model.User;

public class TestUserDAO {

	@Test
	public void test() throws Exception {
		new UserDAO().returnAllUsers();

		// new UserDAO().registerUser(new User("pesho", "petur", "petrovV1",
		// "pesho@abv.bg", "0883343440", "petrovV1", Gender.MALE));

		// new UserDAO().login(new User("m.mihalcheva", "mirelaA1"));
		//
		// Passanger passanger = new Passanger("mirela", "vlaeva",
		// Gender.FEMALE, CabinBaggage.LARGE,
		// ChechedInBaggage.HEAVY, true, true, "8A");
		//
		// Ticket ticket = new Ticket(passanger, "2783462", "2342",
		// LocalDate.now(), LocalDate.now());
		// ticket.setFlight(new Flight("london", "sofia", LocalDate.now()));
		//
		// System.out.println(passanger.toString());
		//
		// List<Passanger> passangers = new ArrayList<Passanger>();
		// passangers.add(passanger);
		// passangers.add(passanger);
		// passangers.add(passanger);
		//
		// new UserDAO().buyTicket(ticket, new User("m.mihalcheva", "mirelaA1"),
		// passangers);

		 User mvlaeva = new User("mvlaeva", "mirelaA1");
		//
		// new UserDAO().getRecentInfo(mvlaeva);
		//
		// new UserDAO().changePassword(mvlaeva, "mirelaA1");
		// new UserDAO().changeEmail(mvlaeva, "m0011@abv.bg");
		// new UserDAO().changePhone(mvlaeva, "0883343440");
		//
		// new UserDAO().getRecentInfo(mvlaeva);
		
		new UserDAO().viewBoughtTickets(mvlaeva);

	}
}