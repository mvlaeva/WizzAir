package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.JsonFlight;
import com.example.model.Passanger;
import com.example.model.Ticket;
import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.TicketException;
import com.example.model.exceptions.UserDAOException;

@Controller
@RequestMapping(value = "/Pay")
public class PayController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		//request.setAttribute("user", user);
		System.out.println("User:" + user);
		
		List<JsonFlight> allFlights = (ArrayList<JsonFlight>) request.getSession().getAttribute("allFlights");
		List<String> mapFlightsIds = (List<String>) request.getSession().getAttribute("mapFlights");
		List<Passanger> adultPassengers = (List<Passanger>) request.getSession().getAttribute("adultPassengers");
		List<JsonFlight> pickedFlights = (List<JsonFlight>) request.getSession().getAttribute("pickedFlights");
		List<Ticket> tickets = new ArrayList<>();
		
		for (Passanger passanger : adultPassengers) {
			try {
				
				for (int index = 0; index < pickedFlights.size(); index++) {

					String origin = pickedFlights.get(index).getOriginStation().toString();
					System.out.println("origin: " + origin);
					String destination = pickedFlights.get(index).getDestinationStation().toString();
					// parse to LocalDateTime :
					String sample = pickedFlights.get(index).getDeparture();
					sample = sample.toString().substring(0, 10);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate dateAndTime = LocalDate.parse(sample, formatter);

					Ticket ticket = new Ticket(passanger, origin, destination, dateAndTime);
					ticket.setFlight(pickedFlights.get(0));
					tickets.add(ticket);
					System.out.println("ticket" + new Ticket(passanger, origin, destination, dateAndTime));
							
				}
				
				new UserDAO().buyTicket(tickets.get(0), user, adultPassengers);

			} catch (UserDAOException | SQLException e) {
				String errorLog = "You cannot purchase a ticket at this time. Please come back later!";
				request.getSession().setAttribute("errorLog", errorLog);
				return "index";
			} catch (NullPointerException e) {
				String errorLog = "An error occured with your flight. Please come back later!";
				request.getSession().setAttribute("errorLog", errorLog);
				return "index";
			} catch (TicketException e) {
				String errorLog = "You cannot purchase a ticket at this time. Please come back later!";
				request.getSession().setAttribute("errorLog", errorLog);
				return "index";
			}
			System.out.println(passanger);
		}
	
		return "greeting";
	}
}
