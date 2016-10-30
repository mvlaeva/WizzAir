package com.wizzair.tests;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;

import com.example.model.FlightSearch;
import com.example.model.APIConnection.ApiDAO;

public class TestAPIConnection {

	@Test
	public void test() throws IOException {
		FlightSearch search = new FlightSearch("one-way", "SOF", "LUT", LocalDate.of(2016, 10, 18).toString(), (LocalDate.of(2016, 10, 18)).toString(), 1, 1, 0);
		try {
			new ApiDAO();
			ApiDAO.getFlights(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
