package itso.rad80.bank.exception;

public class InvalidAmountException extends ITSOBankException {

	private static final long serialVersionUID = 6699692701553657931L;

	//Main Constructor
	public InvalidAmountException(String amount) {
		super("Invalid amount: " + amount);
	}

}
