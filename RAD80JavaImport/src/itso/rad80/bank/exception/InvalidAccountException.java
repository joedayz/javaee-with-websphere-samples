package itso.rad80.bank.exception;

public class InvalidAccountException extends ITSOBankException {

	private static final long serialVersionUID = 3090156256306651865L;

	//Main Constructor
	public InvalidAccountException(String accountNumber) {
		super("Invalid account: Account with number " + accountNumber
				+ " does not exist!");
	}

}
