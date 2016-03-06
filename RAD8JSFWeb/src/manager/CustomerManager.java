package manager;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import itso.bank.entities.Customer;

@Named	
public class CustomerManager {


	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public CustomerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public Customer findCustomerBySsn(String ssn) {
		Customer customer = null;
		EntityManager em = getEntityManager();
		try {
			customer = (Customer) em.find(Customer.class, ssn);
		} finally {
			em.close();
		}
		return customer;
	}
	
	public String updateCustomer(Customer customer) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			customer = em.merge(customer);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	
	
	
}
