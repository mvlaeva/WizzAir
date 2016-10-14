package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.UserException;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println("try get recent info");
			com.example.model.User user =  (com.example.model.User) request.getSession().getAttribute("user");

			request.getSession().setAttribute("user", new UserDAO().getRecentInfo(user));
		} catch (SQLException | UserException e) {
			System.out.println("didnt happen");
			String profileMessage = "Your data is not up-to-date. Please try again later!";
			request.getSession().setAttribute("profileMessage", profileMessage);

			request.getRequestDispatcher("view/profile.jsp").forward(request, response);
		}

		request.getRequestDispatcher("view/profile.jsp").forward(request, response);
	}

}
