package itso.bank.session;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import itso.bank.entities.Transaction;
import itso.bank.exception.ITSOBankException;
import itso.bank.service.EJBBankService;

/**
 * Session Bean implementation class EJBBankBean
 */
@Stateless
@Local(EJBBankService.class)
public class EJBBankBean implements EJBBankService {

	
	@PersistenceContext (unitName="RAD8JPA",
			type=PersistenceContextType.TRANSACTION)
	private EntityManager entityMgr;
 
	   /**
     * Default constructor. 
     */
    public EJBBankBean() {
        // TODO Auto-generated constructor stub
    }

    public void addCustomer(Customer customer) throws ITSOBankException {
		System.out.println("addCustomer: " + customer.getSsn());
		entityMgr.persist(customer);
	}

	public void closeAccount(String ssn, String id) throws ITSOBankException {
		System.out.println("closeAccount: " + id + " of customer " + ssn);
		
		Account account = getAccount(id);
		Transaction[] trans = getTransactions(id);
		for (Transaction tx : trans) {
			entityMgr.remove(tx);
		}
		entityMgr.remove(account);
		System.out.println("closed account with " + trans.length + " transactions");
	}

	public void deleteCustomer(String ssn) throws ITSOBankException {
		System.out.println("deleteCustomer: " + ssn);
		Customer customer = getCustomer(ssn);
		Account[] accounts = getAccounts(ssn);
		for (Account acct : accounts) {
			closeAccount(ssn, acct.getId());
		}
		entityMgr.remove(customer);
	}

	public void deposit(String id, BigDecimal amount) throws ITSOBankException {
		System.out.println("deposit: " + id + " amount " + amount);
		Account account = getAccount(id);
		try {
			Transaction tx = account.processTransaction(amount, Transaction.CREDIT);
			entityMgr.persist(tx);
		} catch (Exception e) {
			throw new ITSOBankException(e.getMessage());	
		}
	}

	public Account getAccount(String id) throws ITSOBankException {
		System.out.println("getAccount: " + id);
		try {
			return entityMgr.find(Account.class, id);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			throw new ITSOBankException(id);
		}
	}

	public Account[] getAccounts(String ssn) throws ITSOBankException {
		System.out.println("getAccounts: " + ssn);
		Query query = null;
		try {
			query = entityMgr.createNamedQuery("getAccountsBySSN");	
			query.setParameter("ssn", ssn);
			List<Account> accountList = query.getResultList();
			Account[] array = new Account[accountList.size()];
			return accountList.toArray(array);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			throw new ITSOBankException(ssn);
		}
	}

	public Customer getCustomer(String ssn) throws ITSOBankException {
		System.out.println("getCustomer: " + ssn);
		//Query query = null;
		try {
			//query = entityMgr.createNamedQuery("getCustomerBySSN");	
			//query.setParameter(1, ssn);
			//return (Customer)query.getSingleResult();
			return entityMgr.find(Customer.class, ssn);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			throw new ITSOBankException(ssn);
		}
	}

	public Customer[] getCustomers(String partialName) throws ITSOBankException {
		System.out.println("getCustomer: " + partialName);
		Query query = null;
		try {
			//select c from Customer c where c.lastName like :name
			query = entityMgr.createNamedQuery("getCustomersByPartialName");
			query.setParameter("name", partialName);
			List<Customer> beanlist = query.getResultList();
			Customer[] array = new Customer[beanlist.size()];
			return beanlist.toArray(array);
		} catch (Exception e) {
			throw new ITSOBankException(partialName);
		} 
	}

	public Customer[] getCustomersAll() {
		System.out.println("getCustomers: all");
		Query query = null;
		try {
			query = entityMgr.createNamedQuery("getCustomers");	
			List<Customer> beanlist = query.getResultList();
			Customer[] array = new Customer[beanlist.size()];
			return beanlist.toArray(array);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}
	
	public Transaction[] getTransactions(String accountID) throws ITSOBankException {
		System.out.println("getTransactions: " + accountID);
		Query query = null;
		try {
			query = entityMgr.createNamedQuery("getTransactionsByID");	
			query.setParameter("aid", accountID);
			List<Transaction> transactionsList = query.getResultList();
			Transaction[] array = new Transaction[transactionsList.size()];
			return transactionsList.toArray(array);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			throw new ITSOBankException(accountID);
		}
	}

	public String openAccount(String ssn) throws ITSOBankException {
		System.out.println("openAccount: " + ssn);
		Customer customer = getCustomer(ssn);
		int acctNumber = (new java.util.Random()).nextInt(899999) + 100000;
		String id = "00" + ssn.substring(0, 1) + "-" + acctNumber;
		Account account = new Account();
		account.setId(id);
		entityMgr.persist(account);

		List<Customer> custSet = Arrays.asList(customer);
		account.setCustomers(custSet);
		System.out.println("openAccount: " + id);
		return id;
	}

	public void transfer(String idDebit, String idCredit, BigDecimal amount) throws ITSOBankException {
		System.out.println("transfer: " + idCredit + " " + idDebit + " amount " + amount);
		withdraw(idDebit, amount);
		deposit(idCredit, amount);
	}

	public void updateCustomer(String ssn, String title, String firstName, String lastName) throws ITSOBankException {
		System.out.println("updateCustomer: " + ssn);
		Customer customer = getCustomer(ssn);
		customer.setTitle(title);
		customer.setLastName(lastName);
		customer.setFirstName(firstName);
		System.out.println("updateCustomer: " + customer.getTitle() + " " + customer.getFirstName() + " " + customer.getLastName());
	}

	public void withdraw(String id, BigDecimal amount) throws ITSOBankException {
	   	System.out.println("withdraw: " + id + " amount " + amount);
		Account account = getAccount(id);
		try {
			Transaction tx = account.processTransaction(amount, Transaction.DEBIT);
			entityMgr.persist(tx);
		} catch (Exception e) {
			throw new ITSOBankException(e.getMessage());	
		}
	}


}