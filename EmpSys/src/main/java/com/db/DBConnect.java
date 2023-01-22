package com.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection con;
	
	public static Connection getcon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
		     return con;
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return con;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
