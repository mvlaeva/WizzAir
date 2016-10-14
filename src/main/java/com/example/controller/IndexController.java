package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.IUser;

@Controller
@RequestMapping(value = "/Home")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response) {

		// doGet(HttpServletRequest request, HttpServletResponse response)
		// throws ServletException, IOException {

		// request.getRequestDispatcher("view/index.jsp").forward(request,
		// response);
		return "/Home";
	}

	protected String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUser user = (IUser) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		doGet(request, response);
		// beshe doget(req, resp)
		return "forward:/Home";
	}
}
