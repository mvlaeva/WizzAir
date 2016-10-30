package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.model.CabinBaggage;
import com.example.model.ChechedInBaggage;
import com.example.model.FlightSearch;
import com.example.model.Gender;
import com.example.model.Passanger;
import com.example.model.Utility;


	@Controller
	@RequestMapping(value = "/Buy")
	public class BuyController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Passanger> adultPassengers = new ArrayList<Passanger>();
		FlightSearch madeSerach = (FlightSearch) request.getSession().getAttribute("search");

		for (int person = 1; person <= (madeSerach.getAdults() + madeSerach.getChildren()); person++) {

			/*
			 * If first or last name are null opens up the same page and shows
			 * message
			 */
			if (request.getParameter("firstName" + person) == null || request.getParameter("firstName" + person) == ""
					|| request.getParameter("lastName" + person) == null
					|| request.getParameter("lastName" + person) == "") {
				String buyMessage = "Please fill all forms!";
				request.setAttribute("buyMessage", buyMessage);
				request.getRequestDispatcher("view/baggage.jsp").forward(request, response);
			}
			System.out.println(request.getParameter("firstName" + person));

			String firstName = request.getParameter(("firstName" + person));
			String lastName = request.getParameter(("lastName" + person));
			Gender gender = Gender.valueOf((request.getParameter(("gender" + person))).toUpperCase());
			CabinBaggage cabinBaggage = CabinBaggage
					.valueOf((request.getParameter(("cabinBaggage" + person))).toUpperCase());
			ChechedInBaggage chechedInBaggage = ChechedInBaggage
					.valueOf((request.getParameter(("chechedInBaggage" + person))).toUpperCase());
			String sportsEquipment = request.getParameter(("sportsEquipment" + person));
			String isOnlineCheckIn = request.getParameter(("checkIn" + person));

			String seat = Utility.constructSeat();

			System.out.println("isOnlineCheckIn :" + isOnlineCheckIn);
			System.out.println("sportsEquipment :" + sportsEquipment);
			adultPassengers.add(new Passanger(firstName, lastName, gender, cabinBaggage, chechedInBaggage,
					sportsEquipment == null ? false : true, isOnlineCheckIn.equals("online") ? true : false, seat));
		}
		
		request.getSession().setAttribute("adultPassengers", adultPassengers);
		return "checkOut";		
	}

}
