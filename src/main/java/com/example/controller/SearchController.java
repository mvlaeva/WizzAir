package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.FlightSearch;
import com.example.model.JsonFlight;
import com.example.model.APIConnection.ApiDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		String departureDate = request.getParameter("departureDate");
		String returnDate = request.getParameter("returnDate");
		int adults = Integer.parseInt(request.getParameter("adults"));
		String stops = request.getParameter("stops");

		FlightSearch search = new FlightSearch(origin, destination, departureDate, returnDate, adults,
				Integer.parseInt(stops));

		List<JsonFlight> allFlights = null;
		try {
			allFlights = ApiDAO.getFlights(search);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getSession().setAttribute("search", search);
		request.getSession().setAttribute("allFlights", allFlights);

		request.getRequestDispatcher("view/flights.jsp").forward(request, response);
	}

}
