package Database_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	
	public static Connection getConn() {
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EducationDB","root","rayal_goluExe@2324");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
