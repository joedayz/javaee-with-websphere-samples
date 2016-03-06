package itso.rad8.webapps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to log off the current user.
 *
 * Parameters: none.
 * 
 * Output (request parameters): none. 
 * 
 * Forwards to:
 * <dl>
 * <dt>redbank.html</dt>
 * <dd>If no error occurred.</dd>
 * 
 * <dt>showException.jsp</dt>
 * <dd>If an error occurs.</dd>
 * </dl>
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
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
			// remove the customer number from the session
			HttpSession session = req.getSession();
			session.removeAttribute("customerNumber");
			session.invalidate();

			// Call the presentation renderer
			ServletContext ctx = getServletContext();
			RequestDispatcher disp = ctx.getRequestDispatcher("redbank.html");
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
