package itso.rad80.bank.model;

import java.lang.String;
import java.util.ArrayList;
import itso.rad80.bank.exception.AccountAlreadyExistException;
import itso.rad80.bank.exception.InvalidAccountException;
import itso.rad80.bank.model.Account;

public class Customer {

	private String ssn = null;
	private String firstName = null;
	private String lastName = null;
	private ArrayList<Account> accounts = null;
	private String title = null;

	//Main Constructor
	public Customer(String ssn, String title, String firstName, String lastName) {
		this.setSsn(ssn);
		this.setTitle(title);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAccounts(new ArrayList<Account>());	
	}	
	//Update customer data logic
	public void updateCustomer(String title, String firstName, String lastName) {
		this.setTitle(title);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}	
	//Add account to customer logic
	public void addAccount(Account account) throws AccountAlreadyExistException {
		if (!this.getAccounts().contains(account)) {
			this.getAccounts().add(account);
		} else {
			throw new AccountAlreadyExistException(account.getAccountNumber());
		}
	}	
	//Remove account from customer logic
	public void removeAccount(Account account) throws InvalidAccountException {
		if (this.getAccounts().contains(account)) {
			this.getAccounts().remove(account);
		} else {
			throw new InvalidAccountException(account.getAccountNumber());
		}	
	}
	@Override
	//Replacement logic for toString on console output
	public String toString() {
		return this.getSsn() + " " + this.getTitle() + " " + this.getLastName()
		+ " " + this.getFirstName();
	}

	// PUBLIC GETTERS
	public String getSsn() {
		return ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	// PRIVATE SETTERS
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
