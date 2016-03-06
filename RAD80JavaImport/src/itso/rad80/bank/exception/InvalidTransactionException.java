package itso.rad80.bank.exception;

import java.math.BigDecimal;

import itso.rad80.bank.model.Account;

public class InvalidTransactionException extends ITSOBankException {

	private static final long serialVersionUID = -4756665135978155919L;

	//Main Constructor
	public InvalidTransactionException(String message) {
		super(message);
	}
	//Main Constructor with fields
	public InvalidTransactionException(Account account, String transactionType,
			BigDecimal amount) {
		super(transactionType.toLowerCase() + " transaction on account "
				+ account.getAccountNumber() + " failed: " + "Could not "
				+ transactionType.toLowerCase() + " $"
				+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
				+ ", because current balance is $"
				+ account.getBalance().setScale(2, BigDecimal.ROUND_HALF_EVEN)
				+ " and negative balances are not allowed.");
	}

}
