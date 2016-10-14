package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// DB transaction with flight, passengers and user insertions
		// Be creative, Mirela (DB Seniorita) and do some magic here
		// pickedFlights, adultPassengers and user from session to DB
		
		request.getRequestDispatcher("view/greeting.jsp").forward(request, response);
	}

}
