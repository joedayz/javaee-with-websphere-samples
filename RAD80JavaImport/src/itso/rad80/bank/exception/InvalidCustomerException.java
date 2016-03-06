package itso.rad80.bank.exception;

public class InvalidCustomerException extends ITSOBankException {

	private static final long serialVersionUID = 115434485097773697L;

	//Main Constructor
	public InvalidCustomerException(String ssn) {
		super("Invalid customer: Customer with ssn " + ssn + " does not exist!");
	}

}
