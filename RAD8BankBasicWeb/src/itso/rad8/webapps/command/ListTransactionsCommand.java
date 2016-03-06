package itso.rad8.webapps.command;

import java.util.ArrayList;

import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;
import itso.rad80.bank.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * List transactions command. Will retrieve the account history and forward
 * to a JSP that can show this information to the user.
 * 
 * Parameters:
 * <dl>
 * <dt>accountId</dt><dd>The account to show the transaction history for</dd>
 * </dl>
 */
public class ListTransactionsCommand implements Command {

	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// Parameters
		String accountId = req.getParameter("accountId");
		
		// Control logic
		Bank bank = ITSOBank.getBank();
		
		// Response
		Account account = bank.searchAccountByAccountNumber(accountId);
		ArrayList<Transaction> transactionList = bank.getTransactionsForAccount(accountId);
		Transaction[] transactions = transactionList.toArray(new Transaction[transactionList.size()]);

		req.setAttribute("account", account);
		req.setAttribute("transactions", transactions);
	}

	public String getForwardView() {
		return "listTransactions.jsp";
	}
}