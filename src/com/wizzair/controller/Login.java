package com.wizzair.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.model.IUser;
import com.wizzair.model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("view/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User sample = new User(username, password);

		try {
			IUser user = new UserDAO().login(sample);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
		} catch (Exception e) {
			String message = "Invalid username/password.";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("./Login");
			return;
		}
	}

}