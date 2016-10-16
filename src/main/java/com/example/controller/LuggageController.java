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

		/*Map<String, String> mapFlights = new HashMap<String, String>();

		for (String header : request.getParameterMap().keySet()) {

			if (header != null) {
				for (String value : request.getParameterMap().get(header)) {
					mapFlights.put(header, value);
				}
			}
		}*/

		List<String> mapFlights = new ArrayList<String>();
		String outgoingFlightId = request.getParameter("outgoingFlightId");
		System.out.println(outgoingFlightId);
		mapFlights.add(outgoingFlightId);
		System.out.println(outgoingFlightId);
		
		request.getSession().setAttribute("mapFlights", mapFlights);
		return "baggage";
	}
}
