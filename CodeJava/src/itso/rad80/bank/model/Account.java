package itso.rad80.bank.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.lang.String;
import java.math.BigDecimal;

import itso.rad80.bank.exception.InvalidTransactionException;
import itso.rad80.bank.ifc.TransactionType;
import itso.rad80.bank.model.Credit;
import itso.rad80.bank.model.Debit;
import itso.rad80.bank.model.Transaction;

public class Account implements Serializable {

	private static final long serialVersionUID = -8162899714780740116L;
	private ArrayList<Transaction> transactions = null;
	private String accountNumber = null;
	private BigDecimal balance = null;

	//Main Constructor
	public Account(String accountNumber, BigDecimal balance) {
		this.setAccountNumber(accountNumber);
		this.setBalance(balance);
		this.setTransactions(new ArrayList<Transaction>());
	}
	//Process transaction logic
	public void processTransaction(BigDecimal amount, String transactionType)
			throws InvalidTransactionException {
		BigDecimal newBalance = null;
		Transaction transaction = null;

		if (TransactionType.CREDIT.equals(transactionType)) {
			transaction = new Credit(amount);
		} else if (TransactionType.DEBIT.equals(transactionType)) {
			transaction = new Debit(amount);
		} else {
			throw new InvalidTransactionException(
					"Invalid transaction type: Please use Debit or Credit. "
							+ "No other transactions are currently supported.");
		}

		newBalance = transaction.process(this.getBalance());
		if (newBalance.doubleValue() < 0) {
			throw new InvalidTransactionException(this, transactionType, amount);
		} else {
			this.setBalance(newBalance);
			this.getTransactions().add(transaction);
		}	
	}
	//Replacement logic for toString on console output
	@Override
	public String toString() {
		StringBuffer accountInfo = new StringBuffer();

		accountInfo.append("Account " + this.getAccountNumber()
				+ ": --> Current balance: $"
				+ this.getBalance().setScale(2, BigDecimal.ROUND_HALF_EVEN));
		if (this.getTransactions().size() > 0) {
			accountInfo.append(System.getProperty("line.separator"));
			accountInfo.append("\tTransactions: ");
			accountInfo.append(System.getProperty("line.separator"));
			for (int i = 0; i < this.getTransactions().size(); i++) {
				accountInfo.append("\t" + (i + 1) + ". "
						+ this.getTransactions().get(i) + "\n");
			}
		}
		return accountInfo.toString();
	}

	// PUBLIC GETTERS
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	// PRIVATE SETTERS
	private void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	private void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	private void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
