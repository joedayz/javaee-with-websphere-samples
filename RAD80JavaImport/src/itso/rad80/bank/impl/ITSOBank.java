package itso.rad80.bank.impl;

import itso.rad80.bank.exception.AccountAlreadyExistException;
import itso.rad80.bank.exception.CustomerAlreadyExistException;
import itso.rad80.bank.exception.InvalidAccountException;
import itso.rad80.bank.exception.InvalidCustomerException;
import itso.rad80.bank.exception.InvalidTransactionException;
import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.ifc.TransactionType;
import itso.rad80.bank.model.Account;
import itso.rad80.bank.model.Customer;
import itso.rad80.bank.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ITSOBank implements Bank {

	private Map<String, Customer> customers = null; 
	private Map<String, Account> accounts = null;
	private Map<String, ArrayList<Account>> customerAccounts = null;
	private static ITSOBank bank = new ITSOBank();

	//Main Constructor
	public ITSOBank() {
		this.setCustomers(new HashMap<String, Customer>());
		this.setAccounts(new HashMap<String, Account>());
		this.setCustomerAccounts(new HashMap<String, ArrayList<Account>>());
		this.initializeBank();
	}
	//Internal logic bond to constructor
	private void initializeBank() {
		try {
			Customer customer1 = new Customer("111-11-1111", "MR", "Ueli", "Wahli");
			this.addCustomer(customer1);
			Customer customer2 = new Customer("222-22-2222", "MR", "Brian", "Hainey");
			this.addCustomer(customer2);
			Customer customer3 = new Customer("333-33-3333", "MR", "Simon", "Kofkin");
			this.addCustomer(customer3);
			Customer customer4 = new Customer("444-44-4444", "MR", "Lei", "Jiang");
			this.addCustomer(customer4);

			Account account11 = new Account("001-999000777", new BigDecimal("1234567.89"));
			this.openAccountForCustomer(customer1, account11);
			Account account12 = new Account("001-999000888", new BigDecimal("6543.21"));
			this.openAccountForCustomer(customer1, account12);
			Account account13 = new Account("001-999000999", new BigDecimal("98.76"));
			this.openAccountForCustomer(customer1, account13);

			Account account21 = new Account("002-999000777", new BigDecimal("65484.23"));
			this.openAccountForCustomer(customer2, account21);
			Account account22 = new Account("002-999000888", new BigDecimal("87.96"));
			this.openAccountForCustomer(customer2, account22);
			Account account23 = new Account("002-999000999", new BigDecimal("654.65"));
			this.openAccountForCustomer(customer2, account23);

			Account account31 = new Account("003-999000777", new BigDecimal("9876.52"));
			this.openAccountForCustomer(customer3, account31);
			Account account32 = new Account("003-999000888", new BigDecimal("568.79"));
			this.openAccountForCustomer(customer3, account32);
			Account account33 = new Account("003-999000999", new BigDecimal("21.56"));
			this.openAccountForCustomer(customer3, account33);

			Account account41 = new Account("004-999000777", new BigDecimal("987.65"));
			this.openAccountForCustomer(customer4, account41);
			Account account42 = new Account("004-999000888", new BigDecimal("1456456.46"));
			this.openAccountForCustomer(customer4, account42);
			Account account43 = new Account("004-999000999", new BigDecimal("23156.46"));
			this.openAccountForCustomer(customer4, account43);
		} catch (itso.rad80.bank.exception.ITSOBankException e) {
			e.printStackTrace();
		}
	}
	//Update customer data in the bank logic
	public void updateCustomer(String ssn, String title, String firstName,
			String lastName) throws InvalidCustomerException {
		this.searchCustomerBySsn(ssn).updateCustomer(title, firstName, lastName);	
	}
	//Transfer process transaction logic
	public void transfer(String debitAccountNumber, String creditAccountNumber,
			BigDecimal amount) throws InvalidAccountException, InvalidTransactionException {
		this.processTransaction(debitAccountNumber, amount,
				itso.rad80.bank.ifc.TransactionType.DEBIT);
		this.processTransaction(creditAccountNumber, amount,
				itso.rad80.bank.ifc.TransactionType.CREDIT);	
	}
	//Add customer to the bank logic
	public void addCustomer(Customer customer) 
		throws CustomerAlreadyExistException {
		if (this.getCustomers().get(customer.getSsn()) == null) {
			this.getCustomers().put(customer.getSsn(), customer);
			this.getCustomerAccounts().put(customer.getSsn(), new ArrayList<Account>());
		} else {
			throw new CustomerAlreadyExistException(customer.getSsn());
		}
	}
	//Remove customer from the bank logic
	public void removeCustomer(Customer customer)
		throws InvalidCustomerException {
		String customerSsn = customer.getSsn();
		if (this.getCustomers().get(customerSsn) != null) {
			ArrayList<Account> accountList = this
					.getAccountsForCustomer(customerSsn);
			for (Account acct : accountList) {
				try {
					this.closeAccountOfCustomer(customer, acct);
				} catch (InvalidAccountException iae) {
					iae.printStackTrace();
				}
			}
			this.getCustomerAccounts().remove(customerSsn);
			this.getCustomers().remove(customerSsn);
		} else {
			throw new InvalidCustomerException(customerSsn);
		}	
	}
	//Open account for customer in the bank logic
	public void openAccountForCustomer(Customer customer, Account account)
		throws InvalidCustomerException, AccountAlreadyExistException {
		String customerSsn = customer.getSsn();
		String accountNumber = account.getAccountNumber();

		if (this.getCustomers().get(customerSsn) != null) {
			if (this.getAccounts().get(accountNumber) == null) {
				this.getAccounts().put(account.getAccountNumber(), account);
				this.getCustomerAccounts().get(customerSsn).add(account);
				customer.addAccount(account);
			} else {
				throw new AccountAlreadyExistException(accountNumber);
			}
		} else {
			throw new InvalidCustomerException(customerSsn);
		}
	}
	//Close account for customer in the bank logic
	public void closeAccountOfCustomer(Customer customer, Account account)
		throws InvalidAccountException, InvalidCustomerException {
		String customerSsn = customer.getSsn();
		String accountNumber = account.getAccountNumber();

		if (this.getCustomers().get(customerSsn) != null) {
			if (this.getAccounts().get(accountNumber) != null) {
				this.getAccounts().remove(accountNumber);
				this.getCustomerAccounts().get(customerSsn).remove(accountNumber);
				customer.removeAccount(account);
			} else {
				throw new InvalidAccountException(accountNumber);
			}
		} else {
			throw new InvalidCustomerException(customerSsn);
		}	
	}
	//Search account for customer in the bank logic
	public Account searchAccountByAccountNumber(String accountNumber)
		throws InvalidAccountException {
		Account account = this.getAccounts().get(accountNumber);
		if (account != null) {
			return account;
		} else {
			throw new InvalidAccountException(accountNumber);
		}	
	}
	//Process transaction for customer in the bank logic
	private void processTransaction(String accountNumber, BigDecimal amount,
		String transactionType) throws InvalidAccountException, InvalidTransactionException {
		Account account = this.searchAccountByAccountNumber(accountNumber);
		account.processTransaction(amount, transactionType);	
	}
	//Process a deposit request logic
	public void deposit(String accountNumber, BigDecimal amount)
		throws InvalidAccountException, InvalidTransactionException {
		this.processTransaction(accountNumber, amount, TransactionType.CREDIT);	
	}
	//Get all accounts for a customer in the bank logic	
	public ArrayList<Account> getAccountsForCustomer(String customerSsn)
		throws InvalidCustomerException {
		if (this.getCustomers().get(customerSsn) != null) {
			return this.getCustomerAccounts().get(customerSsn);
		} else {
			throw new InvalidCustomerException(customerSsn);
		}	
	}
	//Get all transactions per single account logic
	public ArrayList<Transaction> getTransactionsForAccount(String accountNumber)
		throws InvalidAccountException {
		Account account = this.getAccounts().get(accountNumber);
		if (account != null) {
			return account.getTransactions();
		} else {
			throw new InvalidAccountException(accountNumber);
		}	
	}
	//Withdraw transactions per single account logic
	public void withdraw(String accountNumber, BigDecimal amount)
		throws InvalidAccountException, InvalidTransactionException {
		this.processTransaction(accountNumber, amount, TransactionType.DEBIT);	
	}
	//Search customer in the bank by ssn value logic 
	public Customer searchCustomerBySsn(String ssn)
			throws InvalidCustomerException {
		Customer customer = this.getCustomers().get(ssn);
		if (customer != null) {
			return customer;
		} else {
			throw new InvalidCustomerException(ssn);
		}
	}

	// PUBLIC GETTERS
	public Map<String, ArrayList<Account>> getCustomerAccounts() {
		return customerAccounts;
	}
	public Map<String, Account> getAccounts() {
		return accounts;
	}
	public static ITSOBank getBank() {
		return bank;
	}
	public Map<String, Customer> getCustomers() {
		return this.customers;
	}

	// PRIVATE SETTERS
	private void setCustomers(Map<String, Customer> customers) {
		this.customers = customers;
	}
	private void setCustomerAccounts(Map<String, ArrayList<Account>> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}
	private void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
	}
	
}
