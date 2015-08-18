package itso.rad80.bank.model;


import java.math.BigDecimal;
import java.lang.String;

import itso.rad80.bank.exception.InvalidTransactionException;
import itso.rad80.bank.ifc.TransactionType;

public class Debit extends Transaction {

	private static final long serialVersionUID = 3000586429306538684L;

	//Main Constructor	
	public Debit(BigDecimal amount) {
		super(amount);
	}
	//Replacement logic for toString on console output
	@Override
	public String toString() {
		if (this.getAmount() != null) {
			return "Debit: --> Amount $"
				+ this.getAmount().setScale(2, BigDecimal.ROUND_HALF_EVEN) + " on "
				+ this.getTimeStamp();
		} else {
			return "Debit amount is not set. Transaction has failed.";
		}
	}
	//Process debit transaction logic
	public BigDecimal process(BigDecimal accountBalance)
		throws InvalidTransactionException {
		if ((this.getAmount() != null)
				&& (this.getAmount().compareTo(new BigDecimal(0.00D)) > 0)) {
			return accountBalance.subtract(this.getAmount());
		} else {
			if (this.getAmount() != null) {
				throw new InvalidTransactionException(
						"Debit transaction could not proceed: "
								+ "Negative or zero debit amount has dedected. Debit amount is: $"
								+ this.getAmount().setScale(2,
										BigDecimal.ROUND_HALF_EVEN) + ".");
			} else {
				throw new InvalidTransactionException(
						"Debit transaction could not proceed: "
								+ "Debit amount is not set.");
			}
		}
	}	
	
	// PUBLIC GETTERS
	public String getTransactionType() {
		return TransactionType.DEBIT;
	}
}