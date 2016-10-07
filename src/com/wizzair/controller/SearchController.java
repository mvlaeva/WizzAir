package com.wizzair.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.APIConnection.APIQueryDAO;
import com.wizzair.model.Flight;
import com.wizzair.model.FlightSearch;



@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		String departureDate = request.getParameter("departureDate");
		String returnDate = request.getParameter("returnDate");
		String adults = request.getParameter("adults");
		
		FlightSearch search = new FlightSearch(origin, destination, departureDate, returnDate, adults);
		
		List<Flight> allFlights = APIQueryDAO.getFlights(search);
		
		request.setAttribute("allFlights", allFlights);
		
		request.getRequestDispatcher("view/flights.jsp").forward(request, response);
	}

}
