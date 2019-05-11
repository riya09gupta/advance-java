package beans2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class register {
	public int i;
	static Connection con;
	private String username;
	private String password;
	public register() {
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void add(String username,String password) {
		try
		{
			PreparedStatement pstmt =con.prepareStatement("insert into login1 values(?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			i = pstmt.executeUpdate();
			System.out.println("user"+ username);
			System.out.println("pass"+password);
			
		}catch(SQLIntegrityConstraintViolationException e) {
			
			System.out.println("username can,t be null");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
