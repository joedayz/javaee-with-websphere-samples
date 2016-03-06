package itso.bank.service;

import java.math.BigDecimal;

import javax.ejb.Local;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import itso.bank.entities.Transaction;
import itso.bank.exception.ITSOBankException;

@Local
public interface EJBBankService {

	public Customer getCustomer(String ssn) throws ITSOBankException;

	public Customer[] getCustomers(String partialName) throws ITSOBankException;

	public void updateCustomer(String ssn, String title, String firstName, String lastName) throws ITSOBankException;

	public Account[] getAccounts(String ssn) throws ITSOBankException;

	public Account getAccount(String id) throws ITSOBankException;

	public Transaction[] getTransactions(String accountID) throws ITSOBankException;

	public void deposit(String id, BigDecimal amount) throws ITSOBankException; 

	public void withdraw(String id, BigDecimal amount) throws ITSOBankException; 

	public void transfer(String idDebit, String idCredit, BigDecimal amount) throws ITSOBankException;

	public void closeAccount(String ssn, String id) throws ITSOBankException; 

	public String openAccount(String ssn) throws ITSOBankException; 

	public void addCustomer(Customer customer) throws ITSOBankException;

	public void deleteCustomer(String ssn) throws ITSOBankException;
}
