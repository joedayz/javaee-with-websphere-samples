package itso.rad8.webapps.command;

import java.math.BigDecimal;

import itso.rad80.bank.exception.InvalidAmountException;
import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Withdrawal command. Will perform a withdrawal of the specified amount
 * from the specified account.
 * 
 * Parameters:
 * <dl>
 * <dt>amount</dt><dd>The amount cents to withdraw</dd>
 * <dt>accountId</dt><dd>The account number to withdraw from</dd>
 * </dl>
 */
public class WithdrawCommand implements Command {

	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// Parameters
		String accountId = req.getParameter("accountId");
		String strAmount = req.getParameter("amount");
		BigDecimal amount = null;
		
		try { amount = new BigDecimal(strAmount); }
		catch (NumberFormatException x) {
			throw new InvalidAmountException(strAmount);
		}
		
		// Control logic
		Bank bank = ITSOBank.getBank();
		bank.withdraw(accountId, amount);
		
		// Response
		Account account = bank.searchAccountByAccountNumber(accountId);
		req.setAttribute("account", account);
	}

	public String getForwardView() {
		return "accountDetails.jsp";
	}
}