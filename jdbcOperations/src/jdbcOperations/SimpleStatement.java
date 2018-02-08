package jdbcOperations;
import java.sql.*;

public class SimpleStatement {
	
	public static void main(String []args) throws SQLException{
			
		Connection conn=null;
		Statement st =null;
		ResultSet rt =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			st = conn.createStatement();
			rt=st.executeQuery("select * from employee");
			while(rt.next()){
				System.out.println(rt.getString(1)+" "+rt.getString(2)+" "+rt.getString(3)+" "+rt.getInt(4)+" "+rt.getFloat(5));
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				st.close();
				rt.close();
			}
		} 

}
