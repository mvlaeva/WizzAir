package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Pay")
public class PayController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// DB transaction with flight, passengers and user insertions
		// Be creative, Mirela (DB Seniorita) and do some magic here
		// pickedFlights, adultPassengers and user from session to DB

		return "Pay";
		// request.getRequestDispatcher("view/greeting.jsp").forward(request,
		// response);
	}

}
