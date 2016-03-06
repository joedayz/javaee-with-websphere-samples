package itso.bank.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.openjpa.persistence.jdbc.ForeignKey;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the TRANSACT database table.
 * 
 */
@Entity
@Table( name="TRANSACT")
@Inheritance
@DiscriminatorColumn(name="TRANS_TYPE", discriminatorType=DiscriminatorType.STRING, length=32)
public abstract class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String DEBIT  = "Debit";
	public static final String CREDIT = "Credit";

	@Id
	private String id;

	private BigDecimal amount;

	@Column(name="TRANS_TIME")
	private Timestamp transTime;

	//@Column(name="TRANS_TYPE")
	//private String transType;

	//bi-directional many-to-one association to Account
    @ManyToOne
    @ForeignKey
	private Account account;

    public Transaction() {
    	super();
    }
    
	public Transaction(BigDecimal amount) {
		super();
		setId(java.util.UUID.randomUUID().toString());
		//setTransType(transType);
		setAmount(amount);
		setTransTime( new Timestamp(System.currentTimeMillis()) );
	}
	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getTransTime() {
		return this.transTime;
	}

	public void setTransTime(Timestamp transTime) {
		this.transTime = transTime;
	}

	public abstract String getTransType();

	/*public void setTransType(String transType) {
		this.transType = transType;
	}*/

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String toString() {
		return getTransType() + ": " +  getAmount() + " at " + getTransTime() + " (" + getAccount().getId() + ")";
	}
}