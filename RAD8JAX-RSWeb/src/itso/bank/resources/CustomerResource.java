package itso.bank.resources;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import itso.bank.entities.Transaction;
import itso.bank.manager.CustomerManager;

@Path("/customers")
public class CustomerResource {

	private CustomerManager manager;
	private EntityManagerFactory emf;

	public CustomerResource() {
		super();
		emf = Persistence.createEntityManagerFactory("RAD8JPA");
		manager = new CustomerManager(emf);
	}

	@GET
	@Produces("application/json")
	public JSONArray getAllCustomers() throws IOException {
		final List<Customer> allCustomers = manager.getCustomers();
		JSONArray jsonArray = jsonCustomerArray(allCustomers);
		return jsonArray;
	}

	@Path("pname/{pname}")
	@GET
	@Produces("application/json")
	public JSONArray getCustomersByPartialName(@PathParam(value = "pname") String pname) {
		final List<Customer> allCustomers = manager.getCustomersByPartialName(pname);
		JSONArray jsonArray = jsonCustomerArray(allCustomers);
		return jsonArray;
	}
	
	
	@Path("accounts/{ssn}")
	@GET
	@Produces("application/json")
	public JSONArray getAccountsForSsn(@PathParam(value="ssn") String ssn){
	
		final List<Account> allAccounts = manager.getAccountsForSSN(ssn);
		JSONArray jsonArray = AccountResource.jsonAccountArray(allAccounts);
		return jsonArray;
	}
	
	
	
	
	

	private static JSONArray jsonCustomerArray(final List<Customer> allCustomers) {
		JSONArray jsonArray = new JSONArray(allCustomers.size());
		for (Customer customer : allCustomers) {
			jsonArray.add(jsonCustomer(customer));

		}
		return jsonArray;
	}

	private static JSONObject jsonCustomer(Customer customer) {
		JSONObject obj = new JSONObject();
		obj.put("title", customer.getTitle());
		obj.put("firstName", customer.getFirstName());
		obj.put("lastName", customer.getLastName());
		obj.put("ssn", customer.getSsn());
		return obj;
	}
	
	
	public static JSONArray jsonAccountArray(final List<Account> allAccounts){
		JSONArray jsonArray = new JSONArray(allAccounts.size());
		for(Account account: allAccounts){
			jsonArray.add(jsonAccount(account));
		}
		return jsonArray;
	}
	
	public static JSONObject jsonAccount(Account account){
		JSONObject obj = new JSONObject();
		obj.put("id", account.getId());
		obj.put("balance", account.getBalance());
		return obj;
	}
	
	public static JSONArray jsonTransactionArray(final List<Transaction> allTransactions){

		JSONArray jsonArray = new JSONArray(allTransactions.size());
		for(Transaction transaction: allTransactions){
			jsonArray.add(jsonTransaction(transaction));
		}
		return jsonArray;
	}
	
	public static JSONObject jsonTransaction(Transaction transaction){
		JSONObject obj = new JSONObject();
		obj.put("id", transaction.getId());
		obj.put("amount", transaction.getAmount().toPlainString());
		obj.put("transTime", transaction.getTransTime().toString());
		obj.put("transType", transaction.getTransType());
		return obj;
	}
	
	
}
