package com.wizzair.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wizzair.APIConnection.ApiDAO;
import com.wizzair.DBDAOs.AirportNameDAO;
import com.wizzair.model.FlightSearch;
import com.wizzair.model.JsonFlight;

@WebServlet("/SearchController")
public class Search extends HttpServlet {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String prefix = request.getParameter("prefix");
		
		List<String> airports = AirportNameDAO.getSuggestionsByPrefix(prefix);
		
		response.getWriter().print(new Gson().toJson(airports));
	}

}
