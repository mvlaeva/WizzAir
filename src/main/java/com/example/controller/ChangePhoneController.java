package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.model.DBDAOs.UserDAO;

@Controller
@RequestMapping(value = "/changePhone")
public class ChangePhoneController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response) {
		
		return "changePhone";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		String newPhone = request.getParameter("phone");

		try {

			new UserDAO().changePhone(user, newPhone);

			String phoneMessage = "You changed your phone number successfully!";

			request.getSession().setAttribute("phoneMessage", phoneMessage);
			return "changePhone";

		} catch (Exception e) {
			String phoneMessage = "You entered invalid phone number! Please make sure your phone number starts with +3598 and contains 13 digits or starts with 08 and contains 10 digits..";

			request.getSession().setAttribute("phoneMessage", phoneMessage);
			return "changePhone";
		}
	}
}
