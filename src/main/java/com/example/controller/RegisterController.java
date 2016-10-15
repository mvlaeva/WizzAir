package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Gender;
import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.UserDAOException;
import com.example.model.exceptions.UserException;

@Controller
@RequestMapping(value = "/Register")
public class RegisterController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String regMessage = (String) request.getSession().getAttribute("regMessage");

		request.getSession().setAttribute("regMessage", regMessage);

		return "register";

		// request.getRequestDispatcher("view/Register.jsp").forward(request,
		// response);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response)
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
			// request.getRequestDispatcher("view/index.jsp").forward(request,
			// response);

			return "index";

		} catch (UserDAOException e) {
			regMessage = "This username is already taken!";

		} catch (UserException e) {
			regMessage = "You entered invalid password! Please make sure your password contains 1 uppercase, 1 lowercase, 1 digit"
					+ " and contains more than 6 symbols!";

		} catch (SQLException e) {
			regMessage = "Something went wrong. Please try again later!";

		} catch (NullPointerException e) {
			regMessage = "Please fill all forms!";
		}

		request.setAttribute("regMessage", regMessage);
		// request.getRequestDispatcher("view/Register.jsp").forward(request,
		// response);
		return "register";
	}
}