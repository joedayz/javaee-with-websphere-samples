package itso.rad80.bank.exception;

public class AccountAlreadyExistException extends ITSOBankException {

	private static final long serialVersionUID = 4307114290966505087L;

	//Main Constructor
	public AccountAlreadyExistException(String accountNumber) {
		super("Invalid account: Account with number " + accountNumber
				+ " does already exist!");
	}
	
}
