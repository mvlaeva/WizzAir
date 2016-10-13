package com.wizzair.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.model.CabinBaggage;
import com.wizzair.model.ChechedInBaggage;
import com.wizzair.model.FlightSearch;
import com.wizzair.model.Gender;
import com.wizzair.model.Passanger;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Passanger> adultPassangers = new ArrayList<Passanger>();
		FlightSearch madeSerach = (FlightSearch) request.getSession().getAttribute("search");
		String letters = "ABCDEF";
		
		for (int person = 1; person <= madeSerach.getAdults(); person++) {
			
			String firstName = request.getParameter(("firstName" + person));
			String lastName = request.getParameter(("lastName" + person));
			Gender gender = Gender.valueOf((request.getParameter(("gender" + person))).toUpperCase());
			CabinBaggage cabinBaggage = CabinBaggage.valueOf((request.getParameter(("cabinBaggage" + person))).toUpperCase());
			ChechedInBaggage chechedInBaggage = ChechedInBaggage.valueOf((request.getParameter(("chechedInBaggage" + person))).toUpperCase());
			String sportsEquipment = request.getParameter(("sportsEquipment" + person));
			String isOnlineCheckIn = request.getParameter(("checkIn" + person));
			String seat = "" +((new Random().nextInt(31)) + (letters.charAt((new Random().nextInt(letters.length())))));
		
			System.out.println("isOnlineCheckIn :" + isOnlineCheckIn);
			adultPassangers.add(new Passanger(firstName, lastName, gender, cabinBaggage, chechedInBaggage, sportsEquipment == null ? false : true, isOnlineCheckIn.equals("online")? true : false , seat));
		}
		
		for (Passanger passanger : adultPassangers) {
			System.out.println(passanger);
		}		
	}
}
