package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Book")
public class BookController {
       
	@RequestMapping(method = RequestMethod.GET)
	public String bookTicket(Model Model)  {
				
		return "Book";
	}

}
