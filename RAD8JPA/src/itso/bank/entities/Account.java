package itso.bank.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
	@NamedQuery(name="getAccountsBySSN", query="select a from Account a, in(a.customers) c where c.ssn =:ssn order by a.id"),
    @NamedQuery(name="getTransactionsByID", query="select t from Account a, in(a.transacts) t where a.id =:aid order by t.transTime")
})
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private BigDecimal balance;

	//bi-directional many-to-many association to Customer
    @ManyToMany
	@JoinTable(
			 name="ACCOUNT_CUSTOMER"
		, joinColumns={
			@JoinColumn(name="ACCOUNT_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CUSTOMER_SSN")
			}
		)
	private List<Customer> customers;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="account")
	private List<Transaction> transacts;

    public Account() {
    	super();
    	setBalance(new BigDecimal(0.00));
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	private void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public List<Transaction> getTransacts() {
		return this.transacts;
	}

	public void setTransacts(List<Transaction> transacts) {
		this.transacts = transacts;
	}
	
	public Transaction processTransaction(BigDecimal amount, String transactionType) throws Exception {
		Transaction transaction = null;
		if (Transaction.CREDIT.equals(transactionType)) {
			balance = balance.add(amount);
			transaction = new Credit(amount);
		} else if (Transaction.DEBIT.equals(transactionType)) {
			if (balance.compareTo(amount) < 0)
				throw new Exception("Not enough funds for DEBIT of " + amount);
			balance = balance.subtract(amount);
			transaction = new Debit(amount);
		} else
			throw new Exception("Invalid transaction type");
		transaction.setAccount(this);
		return transaction;
	}
	
	public String toString(){
		return "Account: " + getId() + " balance "+getBalance(); 
	}
	
}