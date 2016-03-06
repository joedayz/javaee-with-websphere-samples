package itso.bank.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table ( name="CUSTOMER")
@NamedQueries({
    @NamedQuery(name="getCustomers", query="select c from Customer c"),
    @NamedQuery(name="getCustomerBySSN", query="select c from Customer c where c.ssn =:ssn"),
    @NamedQuery(name="getCustomersByPartialName", query="select c from Customer c where c.lastName like :name"),
    @NamedQuery(name="getAccountsForSSN", query="select a from Customer c, in(c.accounts) a where c.ssn =:ssn order by a.id")
})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ssn;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String title;

	//bi-directional many-to-many association to Account
	@ManyToMany(mappedBy="customers")
	private List<Account> accounts;

    public Customer() {
    }

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String toString() {
		return "Customer: " + getSsn() + " "  + getTitle() + " " + getFirstName() + " " + getLastName();
	}
	
}