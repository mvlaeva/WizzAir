package com.wizzair.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.model.User;

@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("view/changePassword.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		String newPassword = request.getParameter("password");
		
		try {

			new UserDAO().changePassword(user, newPassword);

			String passMessage = "You changed your password successfully!";

			request.getSession().setAttribute("passMessage", passMessage);
			request.getRequestDispatcher("view/changePassword.jsp").forward(request, response);

		} catch (Exception e) {
			String passMessage = "You entered invalid password! Your password must contain at least 6 characters, 1 uppercase, 1 lowercase and 1 number.";

			request.getSession().setAttribute("passMessage", passMessage);
			request.getRequestDispatcher("view/changePassword.jsp").forward(request, response);
		}
	}
}
