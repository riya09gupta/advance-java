package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
//import java.util.ArrayList;

public class DBconnection {
	public int i;
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(String username,String password) {
		try
		{
			PreparedStatement pstmt =con.prepareStatement("insert into login1 values(?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			i = pstmt.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			
			System.out.println("username can,t be null");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
