package itso.bank.resources;

import static itso.bank.resources.ErrorUtil.jSONObjectResponse;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import itso.bank.entities.Account;
import itso.bank.entities.Credit;
import itso.bank.entities.Debit;
import itso.bank.entities.Transaction;
import itso.bank.manager.AccountManager;
import itso.bank.manager.CreditManager;
import itso.bank.manager.DebitManager;

@Path("/transaction")
public class TransactionResource {
	private CreditManager creditManager;
	private DebitManager debitManager;
	private EntityManagerFactory emf;

	public TransactionResource() {
		super();
		emf = Persistence.createEntityManagerFactory("RAD8JPA");
		creditManager = new CreditManager(emf);
		debitManager = new DebitManager(emf);
	}

	@GET
	@Path("{transactionId}")
	@Produces("application/json")
	public JSONObject getTransaction(@PathParam(value = "transactionId") String transactionId) {
		Transaction creditTransaction = creditManager.findCreditById(transactionId);
		Transaction debitTransaction = debitManager.findDebitById(transactionId);
		if (creditTransaction == null && debitTransaction == null)
			throw new WebApplicationException(jSONObjectResponse(Status.BAD_REQUEST, "Transaction Not Found"));
		else if (creditTransaction != null && debitTransaction != null)
			throw new WebApplicationException(
					jSONObjectResponse(Status.INTERNAL_SERVER_ERROR, "Transaction is both debit and credit"));
		else if (creditTransaction != null)
			return jsonTransaction(creditTransaction);
		else
			return jsonTransaction(debitTransaction);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public JSONObject createTransaction(JSONObject inputObj) throws WebApplicationException {

		String transType = (String) inputObj.get("transType");
		Transaction transaction = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RAD8JPA");
		AccountManager accountManager = new AccountManager(emf);
		Account account = accountManager.findAccountById((String) inputObj.get("accountId"));
		if (account == null)
			throw new WebApplicationException(jSONObjectResponse(Status.BAD_REQUEST, "No Account Found"));

		Transaction persistedTransaction = null;
		if (transType.equals("Credit")) {
			transaction = new Credit(BigDecimal.valueOf(Double.parseDouble(inputObj.get("amount").toString())));
			try {
				transaction.setAccount(account);
				creditManager.createCredit((Credit) transaction);
				persistedTransaction = creditManager.findCreditById(transaction.getId());
			} catch (Exception e) {

				throw new WebApplicationException(jSONObjectResponse(Status.INTERNAL_SERVER_ERROR, e.getMessage()));

			}
		} else if (transType.equals("Debit")) {
			transaction = new Debit(BigDecimal.valueOf(Double.parseDouble(inputObj.get("amount").toString())));
			try {
				transaction.setAccount(account);
				debitManager.createDebit((Debit) transaction);
				persistedTransaction = debitManager.findDebitById(transaction.getId());
			} catch (Exception e) {
				throw new WebApplicationException(jSONObjectResponse(Status.INTERNAL_SERVER_ERROR, e.getMessage()));

			}
		} else {

			throw new WebApplicationException(
					jSONObjectResponse(Status.BAD_REQUEST, transType + " should be Debit or Credit"));

		}

		return jsonTransaction(persistedTransaction);
	}

	public static JSONArray jsonTransactionArray(final List<Transaction> allTransactions) {
		JSONArray jsonArray = new JSONArray(allTransactions.size());
		for (Transaction transaction : allTransactions) {
			jsonArray.add(jsonTransaction(transaction));
		}
		return jsonArray;
	}

	public static JSONObject jsonTransaction(Transaction transaction) {
		JSONObject obj = new JSONObject();
		obj.put("id", transaction.getId());
		obj.put("amount", transaction.getAmount().toPlainString());
		obj.put("transTime", transaction.getTransTime().toString());
		obj.put("transType", transaction.getTransType());
		return obj;
	}

}
