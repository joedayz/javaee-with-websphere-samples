package itso.rad8.webapps.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Command interface. This is based on the Task, or Command, design
 * pattern.
 * Used for servlet processing, the class provides only two methods:
 * <code>execute</code> and <code>getForwardView</code>.
 */
public interface Command {
	/**
	 * Execute the command. The passed-in serlvet request and response
	 * can be used just like any servlet. If an exception is thrown, control
	 * is forwarded to the showError.jsp page.
	 * 
	 * @param req The HTTP request
	 * @param resp The HTTP response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception;
	
	/**
	 * @return The requested view to forward to after executing the command,
	 *         or <code>null</code> if no forwarding should take place.
	 */
	public String getForwardView();
}