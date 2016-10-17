package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;

@Controller
@RequestMapping(value = "/ViewHistory")
public class ViewHistoryController {

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			User user = (User) request.getSession().getAttribute("user");

			System.out.println(user.getUsername());

			request.getSession().setAttribute("boughtTickets", user.getBoughtTickets());

			// request.getRequestDispatcher("view/viewHistory.jsp").forward(request,
			// response);

			return "viewHistory";

		} else {
			String viewHistoryMessage = "Session timed out!";
			request.getSession().setAttribute("viewHistoryMessage", viewHistoryMessage);
			// request.getRequestDispatcher("./index").forward(request,
			// response);

			return "forward:/Home";
		}
	}

}
