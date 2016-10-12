package com.wizzair.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.exceptions.FlightDAOException;
import com.wizzair.exceptions.UserException;
import com.wizzair.model.Gender;
import com.wizzair.model.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("view/Register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dao reg
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		try {
			User sample = new User(username, firstName, lastName, email, phone, password, Gender.MALE);

			new UserDAO().registerUser(sample);
			request.setAttribute("username", username);
			request.setAttribute("password", password);

			request.getRequestDispatcher("/Login").forward(request, response);
		} catch (UserException | SQLException | FlightDAOException e) {
			response.sendRedirect("view/Register.jsp");
			return;
		}
	}
}
