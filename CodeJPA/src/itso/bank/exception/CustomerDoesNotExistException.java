package itso.bank.exception;

/**
 * This exception is thrown when an invalid customer number is entered.
 */

public class CustomerDoesNotExistException extends Exception {

	private static final long serialVersionUID = 2606574988615510272L;

	public CustomerDoesNotExistException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}
}
