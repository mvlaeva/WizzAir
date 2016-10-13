package com.wizzair.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import com.wizzair.model.JsonFlight;
import com.wizzair.model.Passanger;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Passanger> adultPassengers = new ArrayList<Passanger>();
		FlightSearch madeSerach = (FlightSearch) request.getSession().getAttribute("search");

		for (int person = 1; person <= madeSerach.getAdults(); person++) {

			if (request.getParameter("firstName" + person) == null || request.getParameter("firstName" + person) == ""
					|| request.getParameter("lastName" + person) == null
					|| request.getParameter("lastName" + person) == "") {
				String buyMessage = "Please fill all forms!";
				request.setAttribute("buyMessage", buyMessage);
				request.getRequestDispatcher("view/baggage.jsp").forward(request, response);
			}
			System.out.println(request.getParameter("firstName" + person));

			System.out.println(request.getParameter("firstName" + person));

			String firstName = request.getParameter(("firstName" + person));
			String lastName = request.getParameter(("lastName" + person));
			Gender gender = Gender.valueOf((request.getParameter(("gender" + person))).toUpperCase());
			CabinBaggage cabinBaggage = CabinBaggage
					.valueOf((request.getParameter(("cabinBaggage" + person))).toUpperCase());
			ChechedInBaggage chechedInBaggage = ChechedInBaggage
					.valueOf((request.getParameter(("chechedInBaggage" + person))).toUpperCase());
			String sportsEquipment = request.getParameter(("sportsEquipment" + person));
			String isOnlineCheckIn = request.getParameter(("checkIn" + person));

			String seat = constructSeat();

			System.out.println("isOnlineCheckIn :" + isOnlineCheckIn);
			adultPassengers.add(new Passanger(firstName, lastName, gender, cabinBaggage, chechedInBaggage,
					sportsEquipment == null ? false : true, isOnlineCheckIn.equals("online") ? true : false, seat));
		}

		for (Passanger passanger : adultPassengers) {
			System.out.println(passanger);
		}

		List<JsonFlight> pickedFlights = new ArrayList<JsonFlight>();
		List<JsonFlight> allFlights = (ArrayList<JsonFlight>) request.getSession().getAttribute("allFlights");
		Map<String, String> mapFlightsIds = (HashMap<String, String>) request.getSession().getAttribute("mapFlights");

		for (int index = 0; index < allFlights.size(); index++) {
			for (Entry<String, String> flight : mapFlightsIds.entrySet()) {
				if (allFlights.get(index).getId().equals(flight.getKey())) {
					pickedFlights.add(allFlights.get(index));
				}
			}
		}

		request.getSession().setAttribute("pickedFlights", pickedFlights);
		request.getSession().setAttribute("adultPassengers", adultPassengers);
		request.getRequestDispatcher("view/checkOut.jsp").forward(request, response);
	}

	public static String constructSeat() {
		String letters = "ABCDEF";
		String seat = "" + (new Random().nextInt(31) + "" + (letters.charAt(new Random().nextInt(letters.length()))));
		return seat;
	}

}
