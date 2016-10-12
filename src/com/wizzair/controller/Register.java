package com.wizzair.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.exceptions.UserDAOException;
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Gender gender = (request.getParameter("gender").equals(Gender.MALE)) ? Gender.MALE : Gender.FEMALE;

		try {
			User sample = new User(username, firstName, lastName, email, phone, password, gender);

			User user = new UserDAO().registerUser(sample);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
		} catch (UserException e) {
			String message = "User already exists!";
			request.setAttribute("message", message);
			response.sendRedirect("view/Register.jsp");
			return;
		} catch (SQLException | UserDAOException å) {
			String message = "Something went wrong. Please try again later!";
			request.setAttribute("message", message);
			response.sendRedirect("view/Register.jsp");
			return;
		}
	}
}
