package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Luggage")
public class LuggageController {

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {

		List<String> mapFlights = new ArrayList<String>();
		String outgoingFlightId = request.getParameter("outgoingFlightId");
		String incomigFlightId = request.getParameter("incomingFlightId");
		
		mapFlights.add(outgoingFlightId);
		mapFlights.add(incomigFlightId);
		
		System.out.println(outgoingFlightId);
		System.out.println(incomigFlightId);
		
		request.getSession().setAttribute("mapFlights", mapFlights);
		return "baggage";
	}
}