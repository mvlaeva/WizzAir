package com.wizzair.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Luggage")
public class Luggage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> mapFlights = new HashMap<String, String>();

		for (String header : request.getParameterMap().keySet()) {
			if (header != null) {
				for (String value : request.getParameterMap().get(header)) {
					mapFlights.put(header, value);
				}
			}
		}
		
		request.getSession().setAttribute("mapFlights", mapFlights);
		request.getRequestDispatcher("view/baggage.jsp").forward(request, response);
		
	}
}
