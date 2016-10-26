package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.FlightSearch;
import com.example.model.JsonFlight;
import com.example.model.APIConnection.ApiDAO;
import com.example.model.APIConnection.ApiFromTextDAO;
import com.example.model.*;

@Controller
@RequestMapping(value = "/SearchController")
public class SearchController {

	@RequestMapping(method = RequestMethod.POST)
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String direction = request.getParameter("flight");
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		String departureDate = request.getParameter("departureDate");
		String returnDate = request.getParameter("returnDate");
		int adults = Integer.parseInt(request.getParameter("adults"));
		int children = Integer.parseInt(request.getParameter("children"));
		int stops = Integer.parseInt(request.getParameter("stops"));

		FlightSearch search = new FlightSearch(direction, origin, destination, departureDate, 
				returnDate, adults, children, stops);

		List<JsonFlight> allFlights = null;
		try {
			allFlights = ApiDAO.getFlights(search);
			//allFlights= ApiFromTextDAO.getFlights();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getSession().setAttribute("search", search);
		request.getSession().setAttribute("allFlights", allFlights);

		return "flights";
	}

}
