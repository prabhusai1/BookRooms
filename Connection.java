package com.maven.roomsbooking.Utility;

import java.sql.DriverManager;


public class Connection {
	public void connectDB() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roomsbooking","root","mysql");
	}
}