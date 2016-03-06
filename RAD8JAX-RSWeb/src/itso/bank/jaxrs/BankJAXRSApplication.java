package itso.bank.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import itso.bank.resources.AccountResource;
import itso.bank.resources.CustomerResource;
import itso.bank.resources.TransactionResource;


public class BankJAXRSApplication extends Application {

	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(CustomerResource.class);
		classes.add(AccountResource.class);
		classes.add(TransactionResource.class);
		return classes;

	}


}
