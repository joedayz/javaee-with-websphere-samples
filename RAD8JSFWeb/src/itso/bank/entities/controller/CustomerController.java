package itso.bank.entities.controller;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import manager.AccountManager;
import manager.CustomerManager;

@Named
public class CustomerController extends PageCodeBase{


	private Customer customer;
	private List<Account> accountList;
	
	@Inject
	private CustomerManager customerManager;
	
	@Inject
	private AccountManager accountManager;

	public Customer getCustomer() {
		if (customer == null) {
			String ssn = (String) getSessionScope().get("customerId");

			customer = customerManager.findCustomerBySsn(ssn);
		}
		return customer;
	}

	public List<Account> getAccountList() {
		if (accountList == null) {
			
			Object ssn = getSessionScope().get("customerId");
			accountList = accountManager.getAccountBySSN(ssn);
		}
		return accountList;
	}
	
	
	public void handleAjax(AjaxBehaviorEvent event)
			throws javax.faces.event.AbortProcessingException {
		
		try {
			customerManager.updateCustomer(customer);
		} catch (Exception e) {
			logException(e);
		}

	}
	
	public String doUpdateAction() {
		
		try {
			customerManager.updateCustomer(customer);
		} catch (Exception e) {
			logException(e);
		}
		return "update";
	}
	
}
