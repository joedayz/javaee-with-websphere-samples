package itso.rad8.webapps.command;

import java.math.BigDecimal;

import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;
import itso.rad80.bank.exception.InvalidAmountException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Transfer command. Will perform a transfer of the specified amount
 * from one account to another.
 * 
 * Parameters:
 * <dl>
 * <dt>amount</dt><dd>The amount of cents to transfer</dd>
 * <dt>accountId</dt><dd>The debit account</dd>
 * <dt>targetAccountId</dt><dd>The credit account</dd>
 * </dl>
 */
public class TransferCommand implements Command {

	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// Parameters
		String debitAccountNumber = req.getParameter("accountId");
		String creditAccountNumber = req.getParameter("targetAccountId");
		String strAmount = req.getParameter("amount");
		BigDecimal amount = null;
		
		try { amount = new BigDecimal(strAmount); }
		catch (NumberFormatException x) {
			throw new InvalidAmountException(strAmount);
		}
		
		// Control logic
		Bank bank = ITSOBank.getBank();
		bank.transfer(debitAccountNumber, creditAccountNumber, amount);
		
		// Response
		Account account = bank.searchAccountByAccountNumber(debitAccountNumber);
		req.setAttribute("account", account);
	}

	public String getForwardView() {
		return "accountDetails.jsp";
	}
}