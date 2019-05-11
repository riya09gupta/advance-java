package list;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.xdevapi.Statement;


@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loading");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			System.out.println("stablish connection");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>posts</h1>");
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from posts");
			
			
			out.println("<table border = 1>");
			out.println("<tr>");
			out.println("<th>");
			out.println("Id");
			out.println("</th>");
			out.println("<th>");
			out.println("title");
			out.println("</th>");
			out.println("<th>");
			out.println("body");
			out.println("</th>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getInt(1));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(3));
				out.println("</td>");
				out.println("</tr>");
				
			}
			out.println("</table>");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
