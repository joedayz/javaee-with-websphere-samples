package itso.bank.entities;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
@Entity
@Inheritance
@DiscriminatorValue("Credit")
public class Credit extends Transaction {

	private static final long serialVersionUID = 1L;
	public Credit() {
		super(new BigDecimal(0.00));
	}

	public Credit(BigDecimal amount) {
		super(amount);
		
	}

	@Override
	public String getTransType() {
		// 
		return Transaction.CREDIT;
	}

}
