package itso.bank.model.simple;

import java.io.Serializable;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import itso.bank.entities.Customer;




@WebService(name="Bank", targetNamespace="http://simple.model.bank.rad8.itso/", serviceName="BankService", portName="BankPort")
public class SimpleBankBean implements  Serializable {
	
	
	@PersistenceContext(unitName = "CodeJPA", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityMgr;  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@WebMethod(operationName="RetrieveCustomerName", action="urn:getCustomerFullName")
	@WebResult(name="CustomerFullName")
	public String getCustomerFullName(@WebParam(name="ssn")String ssn)
	{
		try {

			Customer customer = entityMgr.find(Customer.class, ssn);
			return customer.getFirstName() + " " + customer.getLastName();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}		
		return null;
	}
	
	

}
