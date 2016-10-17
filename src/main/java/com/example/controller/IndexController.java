package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.model.IUser;

@Controller
@RequestMapping(value = {"/index.html", "/Home"})
public class IndexController  {

	
	@RequestMapping(method = RequestMethod.GET)
	public String sayYo(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) {
		IUser user = (IUser) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		return sayYo(request, response);
	}
}