package com.example.tests;

import java.time.LocalDate;

import org.junit.Test;

import com.example.model.DBDAOs.FlightDAO;

public class TestFlightDAO {

	@Test
	public void test(){
		new FlightDAO().showFlights("Sofia", "Bourgas", LocalDate.of(2016, 10, 25));
	}
}
