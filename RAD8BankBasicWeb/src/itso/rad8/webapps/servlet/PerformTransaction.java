package itso.rad8.webapps.servlet;

import itso.rad8.webapps.command.Command;
import itso.rad8.webapps.command.DepositCommand;
import itso.rad8.webapps.command.ListTransactionsCommand;
import itso.rad8.webapps.command.TransferCommand;
import itso.rad8.webapps.command.WithdrawCommand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to perform a transaction on an account. Will call one of the commands
 * implementing the Command interface.
 *
 * Parameters. In addition to the parameter required by the called command, the
 *             following parameter must be specified:
 * <dl>
 * <dt>transaction</dt>
 * <dd>The transaction to perform. Must be one of: <code>deposit</code>, <code>withdraw</code>,
 *     <code>transfer</code>, <code>list</code>.</dd>
 * </dl>
 * 
 * Output (request parameters): None apart from the ones set by the called command. 
 * 
 * Forwards to: 
 * <dl>
 * <dt><see called command></dt>
 * <dd>If no error occurs.</dd>
 * 
 * <dt>showException.jsp</dt>
 * <dd>If an error occurs.</dd>
 * </dl>
 * 
 * @see itso.rad8.bank.command.Command
 * @see itso.rad8.bank.command.DepositCommand
 * @see itso.rad8.bank.command.WithdrawCommand
 * @see itso.rad8.bank.command.TransferCommand
 * @see itso.rad8.bank.command.ListTransactionsCommand
 */
@WebServlet("/PerformTransaction")
public class PerformTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> commands;	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerformTransaction() {
		commands = new HashMap<String, Command>();
		commands.put("deposit", new DepositCommand());
		commands.put("withdraw", new WithdrawCommand());
		commands.put("transfer", new TransferCommand());
		commands.put("list", new ListTransactionsCommand());
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
		throws ServletException, IOException 
	{
		String transaction = null;

		try {
			// Get input parameter and keep it on the HTTP session
			transaction = req.getParameter("transaction");

			Command command = (Command)commands.get(transaction);
			if (command != null) {
				command.execute(req, resp);

				String forwardView = command.getForwardView();
				if (forwardView != null) {
					// Call the presentation renderer
					ServletContext ctx = getServletContext();
					RequestDispatcher disp = ctx.getRequestDispatcher(forwardView);
					disp.forward(req, resp);
				}
			} else {
				// set up error information and forward to the error page
				req.setAttribute("message", "Unknown transaction: "+transaction);
				req.setAttribute("forward", "index.html");
				ServletContext ctx = getServletContext();
				RequestDispatcher disp = ctx.getRequestDispatcher("showException.jsp");
				disp.forward(req, resp);
			}
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
