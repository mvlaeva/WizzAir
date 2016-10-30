package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.JsonFlight;

@Controller
@RequestMapping(value = "/Luggage")
public class LuggageController {

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {

		List<JsonFlight> allFlights = (ArrayList<JsonFlight>) request.getSession().getAttribute("allFlights");
		List<String> mapFlights = new ArrayList<String>();
		List<JsonFlight> pickedFlights = new ArrayList<JsonFlight>();
		
		String outgoingFlightId = request.getParameter("outgoingFlightId");
		String incomigFlightId = request.getParameter("incomingFlightId");
		
		mapFlights.add(outgoingFlightId);
		mapFlights.add(incomigFlightId);
		
		System.out.println(outgoingFlightId);
		System.out.println(incomigFlightId);
		
		
		
		for (int index = 0; index < allFlights.size(); index++) {
			for (int flight = 0; flight < mapFlights.size(); flight++) {
				if (allFlights.get(index).getId().equals(mapFlights.get(flight))) {
					pickedFlights.add(allFlights.get(index));
				}
			}
		}
		
		request.getSession().setAttribute("pickedFlights", pickedFlights);
		request.getSession().setAttribute("mapFlights", mapFlights);
		return "baggage";
	}
}