package test;

import java.sql.Connection;
import java.sql.SQLException;

public class DriverManager {
	static Connection conn;

	public static Connection getConnection(String url, String user, 
			String password) throws SQLException{
		try {
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}



