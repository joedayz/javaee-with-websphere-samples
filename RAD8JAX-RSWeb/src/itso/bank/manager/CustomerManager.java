package itso.bank.manager;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;



public class CustomerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	
	public CustomerManager(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManager getEntityManager() {
		if (emf == null) {
			throw new RuntimeException(
					"The EntityManagerFactory is null.  This must be passed in to the constructor or set using the setEntityManagerFactory() method.");
		}
		return emf.createEntityManager();
	}

	
	public String createCustomer(Customer customer) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
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

	
	public String deleteCustomer(Customer customer) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			customer = em.merge(customer);
			em.remove(customer);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
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

	
	public String updateCustomer(Customer customer) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			customer = em.merge(customer);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
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

	
	public Customer getNewCustomer() {
	
		Customer customer = new Customer();
	
		return customer;
	}

	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		EntityManager em = getEntityManager();
		List<Customer> results = null;
		try {
			Query query = em.createNamedQuery("getCustomers");
			results = (List<Customer>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerBySSN(String ssn) {
		EntityManager em = getEntityManager();
		List<Customer> results = null;
		try {
			Query query = em.createNamedQuery("getCustomerBySSN");
			query.setParameter("ssn", ssn);
			results = (List<Customer>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersByPartialName(String name) {
		EntityManager em = getEntityManager();
		List<Customer> results = null;
		try {
			Query query = em.createNamedQuery("getCustomersByPartialName");
			query.setParameter("name", name);
			results = (List<Customer>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	
	@SuppressWarnings("unchecked")
	public List<Account> getAccountsForSSN(String ssn) {
		EntityManager em = getEntityManager();
		List<Account> results = null;
		try {
			Query query = em.createNamedQuery("getAccountsForSSN");
			query.setParameter("ssn", ssn);
			results = (List<Account>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}