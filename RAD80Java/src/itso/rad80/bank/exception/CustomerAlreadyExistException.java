package itso.rad80.bank.exception;

public class CustomerAlreadyExistException extends ITSOBankException {

	private static final long serialVersionUID = -3313010076507588192L;

	//Main Constructor
	public CustomerAlreadyExistException(String ssn) {
		super("Invalid customer: Customer with ssn " + ssn
				+ " does already exist!");
	}

}