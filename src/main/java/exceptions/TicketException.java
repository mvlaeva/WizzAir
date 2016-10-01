package exceptions;

public class TicketException extends Exception {

	private static final long serialVersionUID = -388730311543507940L;

	public TicketException() {
		super();
	}

	public TicketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TicketException(String message, Exception cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TicketException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TicketException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
