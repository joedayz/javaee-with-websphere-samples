package itso.bank.manager;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import itso.bank.entities.Account;
import itso.bank.entities.Transaction;

@SuppressWarnings("unchecked")

public class AccountManager {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Resource
	private UserTransaction utx;
	
	
	public AccountManager() {
	
	}

	public AccountManager(EntityManagerFactory emf) {
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

	
	public String createAccount(Account account) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(account);
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


	public String deleteAccount(Account account) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			account = em.merge(account);
			em.remove(account);
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

	
	public String updateAccount(Account account) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			account = em.merge(account);
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

	
	public Account findAccountById(String id) {
		Account account = null;
		EntityManager em = getEntityManager();
		try {
			account = (Account) em.find(Account.class, id);
		} finally {
			em.close();
		}
		return account;
	}

	
	public Account getNewAccount() {
	
		Account account = new Account();
	
		return account;
	}

	
	public List<Account> getAccountsBySSN(String ssn) {
		EntityManager em = getEntityManager();
		List<Account> results = null;
		try {
			Query query = em.createNamedQuery("getAccountsBySSN");
			query.setParameter("ssn", ssn);
			results = (List<Account>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	
	public List<Transaction> getTransactionsByID(String accountId) {
		EntityManager em = getEntityManager();
		List<Transaction> results = null;
		try {
			Query query = em.createNamedQuery("getTransactionsByID");
			query.setParameter("aid", accountId);
			results = (List<Transaction>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}