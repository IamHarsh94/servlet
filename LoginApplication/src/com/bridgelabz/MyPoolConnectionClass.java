package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyPoolConnectionClass {
	
	private static MyPoolConnectionClass instance= null;
	
	private MyPoolConnectionClass(){}
	
	public static MyPoolConnectionClass getInstance(){
		
		if(instance==null){
			instance=new MyPoolConnectionClass();
		}
		return instance;
	}
	
	@SuppressWarnings("unused")
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Connection conn =null;
		Class.forName("com.mysql.jdbc.Driver");	
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo", "root", "root");
		return conn; 
	}
}
