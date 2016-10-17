package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;
import com.example.model.exceptions.UserDAOException;

@Controller
@RequestMapping(value = "/ViewHistory")
public class ViewHistoryController {

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			User user = (User) request.getSession().getAttribute("user");

			System.out.println(user.getUsername());

			try {
				new UserDAO().viewBoughtTickets(user);
			} catch (UserDAOException | SQLException e) {
				String viewHistoryMessage = "Something went wrong!";
				request.getSession().setAttribute("viewHistoryMessage", viewHistoryMessage);
			}
			return "viewHistory";
			
		} else {
			String viewHistoryMessage = "Session timed out!";
			request.getSession().setAttribute("viewHistoryMessage", viewHistoryMessage);

			return "forward:/Home";
		}
	}

}
