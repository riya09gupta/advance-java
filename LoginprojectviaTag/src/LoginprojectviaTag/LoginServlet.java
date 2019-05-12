package LoginprojectviaTag;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded!!!!!!!!!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement pst = con.prepareStatement("select password from login1 where username =?");
			pst.setString(1,username);
			ResultSet rs= pst.executeQuery();
			if (rs.next() && password.equals(rs.getString(1))) {
				HttpSession session = request.getSession();
				session.setAttribute("loginStatus", true);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		
			}
			else {
				out.println("<h1>login not successful</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
		


