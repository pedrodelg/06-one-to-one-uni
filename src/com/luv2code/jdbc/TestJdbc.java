package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "root";
		String pass = "1234";
		
		try {
			
		System.out.println("Conecting to database: " +jdbcUrl);
		
		Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
		System.out.println("Connection succes");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
