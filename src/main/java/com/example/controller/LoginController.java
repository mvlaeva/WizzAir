package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;

@Controller
@RequestMapping(value = "/Login")
public class LoginController  {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response) {

		return "Login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		System.out.println(request.getParameter("username"));
		String password = request.getParameter("password");
		System.out.println(request.getParameter("password"));

		User sample = new User(username, password);

		try {
			User user = (User) new UserDAO().login(sample);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("firstName", user.getFirstName());
			request.getSession().setAttribute("lastName", user.getLastName());
			request.getSession().setAttribute("phone", user.getPhone());
			request.getSession().setAttribute("email", user.getEmail());
		
			if (request.getSession().getAttribute("allFlights") != null) {
				return "flights";
			}
			
			if (request.getSession().getAttribute("pickedFlights") != null) {
				return "forward:/Luggage";
			}

			return "index";
		} catch (Exception e) {
			String message = "Invalid username/password.";
			request.getSession().setAttribute("message", message);
			return "redirect:/Login";
		}
	}
}