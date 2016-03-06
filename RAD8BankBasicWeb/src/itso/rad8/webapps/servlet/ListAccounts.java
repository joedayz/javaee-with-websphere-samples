package itso.rad8.webapps.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;
import itso.rad80.bank.model.Customer;

/**
 * Servlet implementation class ListAccounts
 */
@WebServlet("/ListAccounts")
public class ListAccounts extends HttpServlet {	
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		try {
			// Get input parameter and keep it on the HTTP session
			String customerNumber = req.getParameter("customerNumber");
			HttpSession session = req.getSession();
			if (customerNumber == null)
				customerNumber = (String) session.getAttribute("customerNumber");
			else
				session.setAttribute("customerNumber", customerNumber);

			// Control logic - Create the new banking facade
			Bank bank = ITSOBank.getBank();
			// Retrieve customer and related accounts
			Customer customer = bank.searchCustomerBySsn(customerNumber);

			ArrayList<Account> accountlist = bank.getAccountsForCustomer(customerNumber);
			Account[] accounts = accountlist.toArray(new Account[accountlist.size()]);

			// Response - Set the request attributes for future rendering
			req.setAttribute("customer", customer);
			req.setAttribute("accounts", accounts);

			// Call the presentation renderer
			ServletContext ctx = getServletContext();
			RequestDispatcher disp = ctx.getRequestDispatcher("listAccounts.jsp");
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
