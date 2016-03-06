package itso.bank.entities.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import itso.bank.entities.Transaction;

public class EntityTester {
	
	static EntityManager em; 

	public static void main(String[] args) {
		
		String customerId = "111-11-1111";
		if (args.length > 0) customerId = args[0];
		System.out.println("Entity Testing");
		
		System.out.println("\nCreating EntityManager");
		em = Persistence.createEntityManagerFactory("RAD8JPA").
				createEntityManager();
		System.out.println("RAD8JPA EntityManager successfully created\n");
		em.getTransaction().begin();
		
		System.out.println("\nAll customers: ");
		Query query1 = em.createNamedQuery("getCustomers");
		List<Customer> custList1 = query1.getResultList();
		for (Customer cust : custList1) {
			System.out.println(cust.getSsn() + " " + cust.getTitle() + " " + cust.getFirstName() + " " + cust.getLastName());
		}
		
		System.out.println("\nCustomers by partial name: a");
		Query query2 = em.createNamedQuery("getCustomersByPartialName");
		query2.setParameter("name", "%a%");
		List<Customer> custList2 = query2.getResultList();
		for (Customer cust : custList2) {
			System.out.println(cust.getSsn() + " " + cust.getTitle() + " " + cust.getFirstName() + " " + cust.getLastName());
		}
		
		System.out.println("\nRetrieve one customer: " + customerId);
		Customer cust = em.find(Customer.class, customerId);
		System.out.println(cust.getSsn() + " " + cust.getTitle() + " " + cust.getFirstName() + " " + cust.getLastName());

		List<Account> acctSet = cust.getAccounts();
		System.out.println("Customer has " + acctSet.size() + " accounts");
		for (Account account : acctSet) {
			System.out.println("Account: " + account.getId() + " balance " + account.getBalance());
		}
		
		System.out.println("\nRetrieve customer accounts sorted using named query:");
		Query query3 = em.createNamedQuery("getAccountsBySSN");
		query3.setParameter("ssn", cust.getSsn());
		List<Account> acctList = query3.getResultList();
		for (Account account : acctList) {
			System.out.println("Account: " + account.getId() + " balance " + account.getBalance());
		}
		
		System.out.println("\nPerform transactions on one account: " );
		Account account = acctList.get(0);
		System.out.println("Account: " + account.getId() + " balance " + account.getBalance());
		Transaction tx = null;
		try {
			BigDecimal balance = account.getBalance();
			tx = account.processTransaction(new BigDecimal(100.00), "Credit");
			em.persist(tx);		// make insert persistent
			System.out.println("Tx created: " + tx.getAccount().getId() + " " + tx.getTransType() + " " + tx.getAmount() + " " + tx.getTransTime() + " id " + tx.getId());
			tx = account.processTransaction(new BigDecimal(50.00), "Debit");
			em.persist(tx);
			System.out.println("Tx created: " + tx.getAccount().getId() + " " + tx.getTransType() + " " + tx.getAmount() + " " + tx.getTransTime() + " id " + tx.getId());
			tx = account.processTransaction( balance.add(new BigDecimal(200.00)), "Debit");
			em.persist(tx);
		} catch (Exception e) {
			System.out.println("Transaction failed: " + e.getMessage());
		}

		em.flush();				// make inserts persistent in the DB
		em.refresh(account);	// retrieve account again to access transactions
		
		System.out.println("\nAccount: " + account.getId() + " balance " + account.getBalance());
		
		Query query4 = em.createNamedQuery("getTransactionsByID");
		query4.setParameter("aid", account.getId());
		List<Transaction> transList = query4.getResultList();
		System.out.println("Account has " + transList.size() + " transactions");
		for (Transaction tran : transList) {
			System.out.println("Transaction: " + tran.getTransType() + " " + tran.getAmount() + " " + tran.getTransTime() + " id " + tran.getId());
		}

		em.getTransaction().commit();
	}

}

