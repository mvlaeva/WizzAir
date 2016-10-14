package com.wizzair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wizzair.DBDAOs.UserDAO;
import com.wizzair.model.User;

@WebServlet("/changePhone")
public class changePhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("view/changePhone.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		String newPhone = request.getParameter("phone");

		try {

			new UserDAO().changePhone(user, newPhone);

			String phoneMessage = "You changed your phone number successfully!";

			request.getSession().setAttribute("phoneMessage", phoneMessage);
			request.getRequestDispatcher("view/changePhone.jsp").forward(request, response);

		} catch (Exception e) {
			String phoneMessage = "You entered invalid phone number! Please make sure your phone number starts with +3598 and contains 13 digits or starts with 08 and contains 10 digits..";

			request.getSession().setAttribute("phoneMessage", phoneMessage);
			request.getRequestDispatcher("view/changePhone.jsp").forward(request, response);
		}
	}
}
