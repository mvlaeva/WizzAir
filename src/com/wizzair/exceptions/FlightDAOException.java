package com.wizzair.exceptions;

public class FlightDAOException extends Exception {

	private static final long serialVersionUID = -650325704263111504L;

	public FlightDAOException() {
		super();
	}

	public FlightDAOException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FlightDAOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FlightDAOException(String arg0) {
		super(arg0);
	}

	public FlightDAOException(Throwable arg0) {
		super(arg0);
	}

}
