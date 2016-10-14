package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;

@WebServlet("/changeEmail")
public class changeEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("view/changeEmail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		String newEmail = request.getParameter("email");

		try {

			new UserDAO().changeEmail(user, newEmail);

			String emailMessage = "You changed your email successfully!";

			request.getSession().setAttribute("emailMessage", emailMessage);
			request.getRequestDispatcher("view/changeEmail.jsp").forward(request, response);

		} catch (Exception e) {
			String emailMessage = "You entered invalid email!";

			request.getSession().setAttribute("emailMessage", emailMessage);
			request.getRequestDispatcher("view/changeEmail.jsp").forward(request, response);
		}
	}
}
