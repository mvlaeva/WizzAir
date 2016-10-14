package com.wizzair.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.model.User;

@WebServlet("/viewHistory")
public class viewHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			User user = (User) request.getSession().getAttribute("user");

			System.out.println(user.getUsername());

			request.getSession().setAttribute("boughtTickets", user.getBoughtTickets());

			request.getRequestDispatcher("view/viewHistory.jsp").forward(request, response);
		} else {
			String viewHistoryMessage = "Session timed out!";
			request.getSession().setAttribute("viewHistoryMessage", viewHistoryMessage);
			request.getRequestDispatcher("./index").forward(request, response);
		}
	}

}
