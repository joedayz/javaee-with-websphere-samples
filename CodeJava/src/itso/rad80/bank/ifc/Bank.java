package itso.rad80.bank.ifc;

import itso.rad80.bank.exception.AccountAlreadyExistException;
import itso.rad80.bank.exception.CustomerAlreadyExistException;
import itso.rad80.bank.exception.InvalidAccountException;
import itso.rad80.bank.exception.InvalidCustomerException;
import itso.rad80.bank.exception.InvalidTransactionException;
import itso.rad80.bank.model.Account;
import itso.rad80.bank.model.Customer;
import itso.rad80.bank.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.lang.String;
import java.util.Map;

public interface Bank {

	public Customer searchCustomerBySsn(String ssn) throws InvalidCustomerException;

	public Map<String, Customer> getCustomers();

	public void transfer(String debitAccountNumber, String creditAccountNumber,
			BigDecimal amount) throws InvalidAccountException, InvalidTransactionException;

	public void addCustomer(Customer customer)
			throws CustomerAlreadyExistException;

	public void updateCustomer(String ssn, String title, String firstName,
			String lastName) throws InvalidCustomerException;

	public void removeCustomer(Customer customer)
			throws InvalidCustomerException;

	public void openAccountForCustomer(Customer customer, Account account)
			throws InvalidCustomerException, AccountAlreadyExistException;

	public void closeAccountOfCustomer(Customer customer, Account account)
			throws InvalidCustomerException, InvalidAccountException;

	public Account searchAccountByAccountNumber(String accountNumber)
			throws InvalidAccountException;

	public ArrayList<Account> getAccountsForCustomer(String customerSsn)
			throws InvalidCustomerException;

	public ArrayList<Transaction> getTransactionsForAccount(String accountNumber)
			throws InvalidAccountException;

	public void deposit(String accountNumber, BigDecimal amount)
			throws InvalidAccountException, InvalidTransactionException;

	public void withdraw(String accountNumber, BigDecimal amount)
			throws InvalidAccountException, InvalidTransactionException;

}
