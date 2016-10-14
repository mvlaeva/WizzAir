package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Gender;
import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.UserDAOException;
import com.example.model.exceptions.UserException;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String regMessage = (String) request.getSession().getAttribute("regMessage");

		request.getSession().setAttribute("regMessage", regMessage);
		
		request.getRequestDispatcher("view/Register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String regMessage = "";

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Gender gender = (request.getParameter("gender").equals(Gender.MALE)) ? Gender.MALE : Gender.FEMALE;

		try {
			User user = new User(username, firstName, lastName, email, phone, password, gender);
			new UserDAO().registerUser(user);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
			
		} catch (UserDAOException e) {
			regMessage = "This username is already taken!";
			
		} catch (UserException e) {
			regMessage = "You entered invalid password! Please make sure your password contains 1 uppercase, 1 lowercase, 1 digit"
					+ " and contains more than 6 symbols!";
			
		} catch (SQLException å) {
			regMessage = "Something went wrong. Please try again later!";
			
		} catch (NullPointerException e) {
			regMessage = "Please fill all forms!";
		}

		request.setAttribute("regMessage", regMessage);
		request.getRequestDispatcher("view/Register.jsp").forward(request, response);
		return;
	}
}