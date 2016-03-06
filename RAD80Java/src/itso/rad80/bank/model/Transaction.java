package itso.rad80.bank.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.lang.String;
import java.math.BigDecimal;

import itso.rad80.bank.exception.InvalidTransactionException;

public abstract class Transaction implements Serializable {

	private static final long serialVersionUID = -6391326946307182945L;
	private Timestamp timeStamp = null;
	private int transactionId = 0;
	private BigDecimal amount = null;
	
	static int transactionCtr = 1;  // to increment transactionId

	//Main Constructor
	public Transaction(BigDecimal amount) {
		this.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		this.setAmount(amount);
		this.setTransactionId(transactionCtr++);
	}
	
	//Get transaction abstract logic
	public abstract String getTransactionType();

	//Process transaction abstract logic
	public abstract BigDecimal process(BigDecimal accountBalance)
			throws InvalidTransactionException;

	// PUBLIC GETTERS
	public BigDecimal getAmount() {
		return amount;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public int getTransactionId() {
		return transactionId;
	}
	
	// PRIVATE SETTERS
	private void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	private void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	private void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		if (this.getAmount() != null) {
			return "Transaction: --> Amount $"
				+ this.getAmount().setScale(2, BigDecimal.ROUND_HALF_EVEN) + " on "
				+ this.getTimeStamp();
		} else {
			return "Trasaction amount is not set. Transaction has failed.";
		}
	}

}
