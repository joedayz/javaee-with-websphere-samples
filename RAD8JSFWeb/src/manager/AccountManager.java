package manager;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import itso.bank.entities.Account;

@Named
public class AccountManager {

	

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public AccountManager() {
	
	}
	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	@SuppressWarnings("unchecked")
	public List<Account> getAccountBySSN(Object ssn) {
		EntityManager em = getEntityManager();
		List<Account> results = null;
		try {
			Query query = em.createNamedQuery("getAccountBySSN ");
			query.setParameter("ssn", ssn);
			results = (List<Account>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}
	
}
