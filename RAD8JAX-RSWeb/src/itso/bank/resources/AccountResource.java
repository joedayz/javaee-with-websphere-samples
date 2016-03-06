package itso.bank.resources;

import static itso.bank.resources.ErrorUtil.jSONArrayResponse;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import itso.bank.entities.Account;
import itso.bank.entities.Transaction;
import itso.bank.manager.AccountManager;

@Path("/accounts")
public class AccountResource {
 private AccountManager manager;
 private EntityManagerFactory emf;

 public AccountResource() {
  super();
  emf = Persistence.createEntityManagerFactory("RAD8JPA");
  manager = new AccountManager(emf);

 }

 @Path("ssn/{ssn}")
 @GET
 @Produces("application/json")
 public JSONArray getAllAccounts(@PathParam(value = "ssn") String ssn)  {
  final List<Account> allAccounts = manager.getAccountsBySSN(ssn);
  if (allAccounts ==null ||allAccounts.isEmpty()) 
   throw new WebApplicationException(jSONArrayResponse(Status.BAD_REQUEST,"No account found"));
  JSONArray jsonArray = jsonAccountArray(allAccounts);
  return jsonArray;

 }
 @Path("{accountId}/transactions")
 @GET
 @Produces("application/json")
 public JSONArray getTransactionsByAccountId(@PathParam(value = "accountId") String accountId) {
  final List<Transaction> allTransactions = manager.getTransactionsByID(accountId);
  if (allTransactions ==null ||allTransactions.isEmpty()) 
   throw new WebApplicationException(jSONArrayResponse(Status.BAD_REQUEST,"No transactions found"));
  JSONArray jsonArray = TransactionResource.jsonTransactionArray(allTransactions);
  return jsonArray;

 }


 public static JSONArray jsonAccountArray(final List<Account> allAccounts) {
  JSONArray jsonArray = new JSONArray(allAccounts.size());
  for (Account account : allAccounts) {
   jsonArray.add(jsonAccount(account));
  }
  return jsonArray;
 }

 public static JSONObject jsonAccount(Account account) {
  JSONObject obj = new JSONObject();
  obj.put("id", account.getId());
  obj.put("balance", account.getBalance());
  return obj;
 }

}

