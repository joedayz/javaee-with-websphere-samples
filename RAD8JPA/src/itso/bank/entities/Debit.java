package itso.bank.entities;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
@DiscriminatorValue("Debit")
public class Debit extends Transaction {
	private static final long serialVersionUID = 1L;
	public Debit() {
		super(new BigDecimal(0.00));
	}

	public Debit(BigDecimal amount) {
		super(amount);
	}

	@Override
	public String getTransType() {
		// TODO Auto-generated method stub
		return Transaction.DEBIT;
	}

}
