package com.wizzair.tests;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;

import com.wizzair.APIConnection.APIConnection;

public class TestAPIConnection {

	@Test
	public void test() throws IOException {
		new APIConnection().findFlight("BR", "BRL", "pt-BR", "SDU", "GRU", LocalDate.of(2016, 10, 18), 1);
	}

}
