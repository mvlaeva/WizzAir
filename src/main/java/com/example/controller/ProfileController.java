package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.UserException;

@Controller
@RequestMapping(value = "/Profile")
public class ProfileController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println("try get recent info");
			com.example.model.User user = (com.example.model.User) request.getSession().getAttribute("user");

			request.getSession().setAttribute("user", new UserDAO().getRecentInfo(user));
			
		} catch (SQLException | UserException e) {
			System.out.println("didnt happen");
			String profileMessage = "Your data is not up-to-date. Please try again later!";
			request.getSession().setAttribute("profileMessage", profileMessage);

		}

		return "profile";
	}

}
