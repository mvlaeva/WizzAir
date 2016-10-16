package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;

@Controller
@RequestMapping(value = "/ChangeEmail")
public class ChangeEmailController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response) {
		
		return "changeEmail";	
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		String newEmail = request.getParameter("email");

		try {

			new UserDAO().changeEmail(user, newEmail);

			String emailMessage = "You changed your email successfully!";

			request.getSession().setAttribute("emailMessage", emailMessage);
			return "changeEmail";

		} catch (Exception e) {
			String emailMessage = "You entered invalid email!";

			request.getSession().setAttribute("emailMessage", emailMessage);
			return "changeEmail";
		}
	}
}
