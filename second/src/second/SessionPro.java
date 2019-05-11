package second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionPro
 */
@WebServlet("/SessionPro")
public class SessionPro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		if(username.length()>0) {
			session.setAttribute("name", username);
			context.setAttribute("name", username);
			
		}
		out.println("by request= "+username+"<br>");
		out.println("session id= "+session.getId()+"<br>");
		out.println("by session= "+session.getAttribute("name")+"<br>");
		out.println("by conyexy= "+context.getAttribute("name")+"<br>");
		
		
	}

}
