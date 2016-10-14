package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/Home")
public class IndexController  {

	
	@RequestMapping(method = RequestMethod.GET)
	public String sayYo(Model model) {
		return "index";
	}
	

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUser user = (IUser) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		doGet(request, response);
	}*/
}
