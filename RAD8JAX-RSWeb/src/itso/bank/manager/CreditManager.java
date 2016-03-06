package itso.bank.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import itso.bank.entities.Credit;



public class CreditManager {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public CreditManager() {
	
	}

	public CreditManager(EntityManagerFactory emf) {
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

	
	public String createCredit(Credit credit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(credit);
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

	
	public String deleteCredit(Credit credit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			credit = em.merge(credit);
			em.remove(credit);
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

	
	public String updateCredit(Credit credit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			credit = em.merge(credit);
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

	
	public Credit findCreditById(String id) {
		Credit credit = null;
		EntityManager em = getEntityManager();
		try {
			credit = (Credit) em.find(Credit.class, id);
		} finally {
			em.close();
		}
		return credit;
	}

	
	public Credit getNewCredit() {
	
		Credit credit = new Credit();
	
		return credit;
	}

}