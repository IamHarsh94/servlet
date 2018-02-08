package jdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class resultMetaData {

	public static void main(String args[]) throws SQLException{
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		ResultSetMetaData rm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			st=conn.createStatement();
			rs=st.executeQuery("select * from employee");
			rm=rs.getMetaData();
	
		System.out.println("Total table: "+rm.getColumnCount());
		System.out.println("Column name of 1st column: "+rm.getColumnName(1));
		System.out.println("Column type of 1st column: "+rm.getColumnTypeName(1));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
			st.close();
			rs.close();
			
		}
	}
}
