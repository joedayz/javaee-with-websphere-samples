package itso.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itso.bank.entities.Account;
import itso.bank.entities.Customer;
import itso.bank.entities.Transaction;
import itso.bank.service.EJBBankService;

/**
 * Servlet implementation class BankTest
 */
@WebServlet("/BankTest")
public class BankTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	EJBBankService bank; //  <---- new EJBBankBean()
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Injection bank: " + bank);
			PrintWriter out = response.getWriter();
			String partialName = request.getParameter("partialName");
			out.println("<html><body><h2>Customer Listing</h2>");
			if (partialName == null) partialName = "%";
			else partialName = "%" + partialName + "%";
			
			out.println("<p>Customers by partial Name: " + partialName + "<br>");
			Customer[] customers = bank.getCustomers(partialName);
			
			for (Customer cust : customers) {
				out.println("<br>" + cust);
			}
			
			Customer cust1 = bank.getCustomer("222-22-2222");
			out.println("<p>" + cust1);
		
			Account[] accts = bank.getAccounts(cust1.getSsn());
			out.println("<br>Customer: " + cust1.getSsn() + " has " + accts.length + " accounts");

			Account acct = bank.getAccount("002-222002");
			out.println("<p>" + acct);
			
			out.println("<p>Transactions of account: " + acct.getId());
			Transaction[] trans = bank.getTransactions("002-222002");
			out.println("<p><table border=1><tr><th>Type</th><th>Time</th><th>Amount</th></tr>");
			for (Transaction t : trans) {
				out.println("<tr><td>" + t.getTransType() + "</td><td>" + t.getTransTime() 
							+ "</td><td align=right>" + t.getAmount() + "</td></tr>");
			}
			out.println("</table>");
			
			String newssn = "xxx-xx-xxxx";
			bank.deleteCustomer(newssn);      // for rerun
			out.println("<p>Add a customer:  " + newssn);
			Customer custnew = new Customer();
			custnew.setSsn(newssn);
			custnew.setTitle("Mrs");
			custnew.setFirstName("Julia");
			custnew.setLastName("Roberts");
			bank.addCustomer(custnew);
			Customer cust2 = bank.getCustomer(newssn);
			out.println("<br>" + cust2);
			
			out.println("<p>Open two accounts for customer: " + newssn);
			String id1 = bank.openAccount(newssn);
			String id2 = bank.openAccount(newssn);
			out.println("<br>New accounts: " + id1 + " " + id2);
			Account[] acctnew = bank.getAccounts(newssn);
			out.println("<br>Customer: " + newssn + " has " + acctnew.length + " accounts");
			Account acct1 = bank.getAccount(id1);
			out.println("<br>" + acct1);
			
			out.println("<p>Deposit and withdraw from account: " + id1);
			bank.deposit(id1, new java.math.BigDecimal("777.77"));
			bank.withdraw(id1, new java.math.BigDecimal("111.11"));
			acct1 = bank.getAccount(id1);
			out.println("<br>" + acct1);
			
			trans = bank.getTransactions(id1);
			out.println("<p><table border=1><tr><th>Type</th><th>Time</th><th>Amount</th></tr>");
			for (Transaction t : trans) {
					out.println("<tr><td>" + t.getTransType() + "</td><td>" + t.getTransTime() 
								+ "</td><td align=right>" + t.getAmount() + "</td></tr>");
			}
			out.println("</table>");
			
			out.println("<p>Close the account: " + id1);
			bank.closeAccount(newssn, id1);

			out.println("<p>Update the customer: " + newssn);
			bank.updateCustomer(newssn, "Mrs", "Sylvi", "Sollami");
			cust2 = bank.getCustomer(newssn);
			out.println("<br>" + cust2);

			out.println("<p>Delete the customer: " + newssn);
			bank.deleteCustomer(newssn);
			
			out.println("<p>Retrieve non existing customer: ");
			Customer cust3 = bank.getCustomer("zzz-zz-zzzz");
			out.println("<br>customer: " + cust3);
			
			out.println("<p>End</body></html>");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}	
}
