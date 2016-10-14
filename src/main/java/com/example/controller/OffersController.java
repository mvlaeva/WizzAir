package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Offers")
public class OffersController {

	@RequestMapping(method = RequestMethod.GET)
	protected String doGet(HttpServletRequest request, HttpServletResponse response) {

		return "Offers";
	}
}
