package itso.rad8.webapps.command;

import java.math.BigDecimal;

import itso.rad80.bank.exception.InvalidAmountException;
import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Deposit command. Will perform a deposit of the specified amount to
 * the specified account.
 * 
 * Parameters:
 * <dl>
 * <dt>amount</dt><dd>The amount cents to deposit to the account</dd>
 * <dt>accountId</dt><dd>The account number to deposit to</dd>
 * </dl>
 */
public class DepositCommand implements Command {

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
		bank.deposit(accountId, amount);
		
		// Response
		Account account = bank.searchAccountByAccountNumber(accountId);
		req.setAttribute("account", account);
	}

	public String getForwardView() {
		return "accountDetails.jsp";
	}
}