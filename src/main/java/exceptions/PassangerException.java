package exceptions;

public class PassangerException extends Exception {

	private static final long serialVersionUID = 3227671800798833811L;

	public PassangerException() {
		super();
	}

	public PassangerException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public PassangerException(String arg0, Exception arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PassangerException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PassangerException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
