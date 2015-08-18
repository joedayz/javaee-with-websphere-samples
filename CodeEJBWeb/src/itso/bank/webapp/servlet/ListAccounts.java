package itso.bank.webapp.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import itso.bank.session.view.EJBBankService;

/**
 * Servlet implementation class ListAccounts
 */
@WebServlet("/ListAccounts")
public class ListAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB EJBBankService bank;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAccounts() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			// Get input parameter and keep it on the HTTP session
			String customerNumber = req.getParameter("customerNumber");
			HttpSession session = req.getSession();
			if (customerNumber == null)
				customerNumber = (String) session.getAttribute("customerNumber");
			else
				session.setAttribute("customerNumber", customerNumber);
			
			// Control logic - Use the new banking facade
			
			// Retrieve customer and related accounts
			Customer customer = bank.getCustomer(customerNumber);
			
			if (customer == null) {
				Customer[] customers = bank.getCustomers(customerNumber);
				if (customers.length ==  1) {
					customer = customers[0];
					customerNumber = customer.getSsn();
					session.setAttribute("customerNumber", customerNumber);
				}
			}
			
			Account[] accounts = new Account[0];
			if (customer != null)
				accounts = bank.getAccounts(customerNumber);
			else {
				customer = new Customer();
				customer.setSsn(customerNumber);
				customer.setLastName("NOT FOUND");
			}
			
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
