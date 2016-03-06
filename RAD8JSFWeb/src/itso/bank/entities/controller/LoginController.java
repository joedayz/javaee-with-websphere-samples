package itso.bank.entities.controller;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import itso.bank.entities.Customer;
import manager.CustomerManager;

@Named
public class LoginController extends PageCodeBase{

	@Inject
	CustomerManager customerManager;
	
	public String doLoginAction() {
		try {
			String id = (String) getSessionScope().get("customerId");
			System.out.println("Logon id: " + id);
			
			Customer customer = customerManager.findCustomerBySsn(id);
			if (customer == null) {
				throw new Exception("Customer " + id + " was not found.");				
			}
			return "customerDetails";
		} catch (Exception e) {
			getFacesContext().addMessage("id", new FacesMessage(e.getMessage()));
			return null;
		}
	}
}
