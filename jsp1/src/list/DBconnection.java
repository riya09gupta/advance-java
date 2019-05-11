package list;
//import java.uitl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.cj.xdevapi.Statement;

public class DBconnection {
	private static  Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public ArrayList<Post> getPosts(){
			ArrayList<Post> posts=new ArrayList<>();
			try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from posts");
			while(rs.next()) {
				posts.add(new Post(rs.getInt(1),rs.getString(2),rs.getString(3)));
				
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			return posts;
		}
		
	}


