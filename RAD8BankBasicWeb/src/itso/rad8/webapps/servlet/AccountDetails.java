package itso.rad8.webapps.servlet;

import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to retrieve the details for a given account.
 *
 * Parameters: 
 * <dl>
 * <dt>accountId</dt>
 * <dd>The account number for the account to be shown.</dd>
 * </dl>
 * 
 * Output (request parameters): 
 * <dl>
 * <dt>account</dt>
 * <dd>An instance of the Account class, representing the account
 *     to be displayed.</dd>
 * </dl>
 * 
 * Forwards to:
 * <dl>
 * <dt>accountDetails.jsp</dt>
 * <dd>If the account is found and no other error occurred.</dd>
 * 
 * <dt>showException.jsp</dt>
 * <dd>If the customer is not found, or some other error has occurred.</dd>
 * </dl>
 * 
 * @see itso.rad80.bank.model.Account
 */
@WebServlet("/AccountDetails")
public class AccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		try {
			// parameters
			String accountNumber = req.getParameter("accountId");

			// Control logic - Create the new banking facade
			Bank bank = ITSOBank.getBank();

			// Retrieve customer and related accounts
			Account account = bank.searchAccountByAccountNumber(accountNumber);

			// Response - Set the request attributes for future rendering
			req.setAttribute("account", account);

			// Call the presentation renderer
			ServletContext ctx = getServletContext();
			RequestDispatcher disp = ctx.getRequestDispatcher("accountDetails.jsp");
			disp.forward(req, resp);
		} catch (Exception e) {
			// set up error information and forward to the error page
			req.setAttribute("message", e.getMessage());
			req.setAttribute("forward", "index.html");
			ServletContext ctx = getServletContext();
			RequestDispatcher disp = ctx.getRequestDispatcher("showException.jsp");
			disp.forward(req, resp);
		}
	}
}
