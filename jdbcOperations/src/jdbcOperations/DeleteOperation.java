package jdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {

	
	public static void main(String args[]) throws SQLException{
		
		Connection conn =null;
		Statement st=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			st=conn.createStatement();
			int rst =st.executeUpdate("delete from employee where firstName ='shubham'");
			
			System.out.println(rst+" records affected");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
			st.close();
		}
	}
}
