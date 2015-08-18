package itso.bank.session.view;

import javax.ejb.Remote;

import itso.bank.entities.Customer;

@Remote
public interface EJBBankRemote extends EJBBankService {

	public Customer[] getCustomersAll();
}
