package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.CabinBaggage;
import com.example.model.ChechedInBaggage;
import com.example.model.FlightSearch;
import com.example.model.Gender;
import com.example.model.JsonFlight;
import com.example.model.Passanger;
import com.example.model.Ticket;
import com.example.model.User;
import com.example.model.Utility;
import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.UserDAOException;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Passanger> adultPassengers = new ArrayList<Passanger>();
		FlightSearch madeSerach = (FlightSearch) request.getSession().getAttribute("search");

		for (int person = 1; person <= madeSerach.getAdults(); person++) {

			/*
			 * If first or last name are null opens up the same page and shows
			 * message
			 */
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

			String seat = Utility.constructSeat();

			System.out.println("isOnlineCheckIn :" + isOnlineCheckIn);
			adultPassengers.add(new Passanger(firstName, lastName, gender, cabinBaggage, chechedInBaggage,
					sportsEquipment == null ? false : true, isOnlineCheckIn.equals("online") ? true : false, seat));
		}

		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);

		List<JsonFlight> pickedFlights = new ArrayList<JsonFlight>();
		List<JsonFlight> allFlights = (ArrayList<JsonFlight>) request.getSession().getAttribute("allFlights");
		Map<String, String> mapFlightsIds = (HashMap<String, String>) request.getSession().getAttribute("mapFlights");

		for (Passanger passanger : adultPassengers) {
			try {
				List<Ticket> tickets = new ArrayList<>();

				for (int index = 0; index < pickedFlights.size(); ++index) {

					String origin = pickedFlights.get(index).getOriginStation().toString();
					System.out.println("origin: " + origin);
					String destination = pickedFlights.get(index).getDestinationStation().toString();
					// parse to LocalDateTime :
					String sample = pickedFlights.get(index).getDeparture();
					sample = sample.toString().substring(0, 10);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate dateAndTime = LocalDate.parse(sample, formatter);

					tickets.add(new Ticket(passanger, origin, destination, dateAndTime));

					// TODO see why
					// allFlights.get(index).getOriginStation().toString()
					// returns null
					new UserDAO().buyTicket(tickets.get(index), user, adultPassengers);
				}

			} catch (UserDAOException | SQLException e) {
				String errorLog = "You cannot purchase a ticket at this time. Please come back later!";
				request.getSession().setAttribute("errorLog", errorLog);
				request.getRequestDispatcher("./index").forward(request, response);
				return; // otherwise an exception occures (because of for loop)
			} catch (NullPointerException e) {
				String errorLog = "An error occured with your flight. Please come back later!";
				request.getSession().setAttribute("errorLog", errorLog);
				request.getRequestDispatcher("./index").forward(request, response);
				return;
			}
			System.out.println(passanger);
		}

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

}
