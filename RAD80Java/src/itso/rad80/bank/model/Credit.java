package itso.rad80.bank.model;

import java.math.BigDecimal;
import java.lang.String;

import itso.rad80.bank.exception.InvalidTransactionException;
import itso.rad80.bank.ifc.TransactionType;

public class Credit extends Transaction {

	private static final long serialVersionUID = 9097730281411923364L;
	
	//Main Constructor	
	public Credit(BigDecimal amount) {
		super(amount);
	}
	
	@Override
	//Replacement logic for toString on console output
	public String toString() {
		if (this.getAmount() != null) {
			return "Crebit: --> Amount $"
				+ this.getAmount().setScale(2, BigDecimal.ROUND_HALF_EVEN) + " on "
				+ this.getTimeStamp();
		} else {
			return "Credit amount is not set. Transaction has failed.";
		}
	}
	
	//Process credit transaction logic
	public BigDecimal process(BigDecimal accountBalance)
		throws InvalidTransactionException {
		if ((this.getAmount() != null) &&
			(this.getAmount().compareTo(new BigDecimal(0.00D)) > 0)) {
			return accountBalance.add(this.getAmount());
		} else {
			if (this.getAmount() != null) {
				throw new InvalidTransactionException(
						"Credit transaction could not proceed: "
								+ "Negative or zero credit amount has dedected. Credit amount is: $"
								+ this.getAmount().setScale(2,
										BigDecimal.ROUND_HALF_EVEN) + ".");
			} else {
				throw new InvalidTransactionException(
						"Credit transaction could not proceed: "
								+ "Credit amount is not set.");
			}
		}
	}

	// PUBLIC GETTERS
	public String getTransactionType() {
		return TransactionType.CREDIT;
	}

}
