package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;

@Controller
@RequestMapping(value = "/changePassword")
public class ChangePasswordController  {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response) {
		
		return "changePassword";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		String newPassword = request.getParameter("password");
		
		try {

			new UserDAO().changePassword(user, newPassword);

			String passMessage = "You changed your password successfully!";

			request.getSession().setAttribute("passMessage", passMessage);
			return "changePassword";
		
		} catch (Exception e) {
			String passMessage = "You entered invalid password! Your password must contain at least 6 characters, 1 uppercase, 1 lowercase and 1 number.";

			request.getSession().setAttribute("passMessage", passMessage);
			return "changePassword";
		}
	}
}
