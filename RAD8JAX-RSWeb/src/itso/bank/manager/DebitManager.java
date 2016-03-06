package itso.bank.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import itso.bank.entities.Debit;


public class DebitManager {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public DebitManager() {
	
	}

	public DebitManager(EntityManagerFactory emf) {
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

	
	public String createDebit(Debit debit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(debit);
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

	
	public String deleteDebit(Debit debit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			debit = em.merge(debit);
			em.remove(debit);
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


	public String updateDebit(Debit debit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			debit = em.merge(debit);
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


	public Debit findDebitById(String id) {
		Debit debit = null;
		EntityManager em = getEntityManager();
		try {
			debit = (Debit) em.find(Debit.class, id);
		} finally {
			em.close();
		}
		return debit;
	}

	
	public Debit getNewDebit() {
	
		Debit debit = new Debit();
	
		return debit;
	}

}