package jdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbMetaData {

	public static void main(String args[]) throws SQLException{
		
		Connection conn =  null;
		 @SuppressWarnings("unused")
		java.sql.DatabaseMetaData dbmd = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			dbmd=conn.getMetaData();
			System.out.println("Driver name: "+dbmd.getDriverName());
			System.out.println("Driver version: "+dbmd.getDriverVersion());
			System.out.println("User name: "+dbmd.getUserName());
			System.out.println("Product name: "+dbmd.getDatabaseProductName());
			System.out.println("Product version: "+dbmd.getDatabaseProductVersion());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
}
