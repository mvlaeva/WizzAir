package com.wizzair.tests;

import java.time.LocalDate;

import org.junit.Test;

import com.wizzair.DBDAOs.FlightDAO;

public class TestFlightDAO {

	@Test
	public void test(){
		new FlightDAO().showFlights("Sofia", "Bourgas", LocalDate.of(2016, 10, 25));
	}
}
