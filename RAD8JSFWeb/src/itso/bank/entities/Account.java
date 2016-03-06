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
@NamedQuery(name = "getAccountBySSN ", query = "select a from Account a, in(a.customers) c where c.ssn =:ssn order by a.id")
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

	public void setBalance(BigDecimal balance) {
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
	
}