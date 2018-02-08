package jdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatement {

	public static void main(String args[]) throws SQLException{
		Scanner sc =new Scanner(System.in);
		EmployeeData data = new EmployeeData();
		
		System.out.println("Enter first name:");
		String Fname = sc.nextLine();
		data.setFname(Fname);
		System.out.println("Enter last name:");
		String Lname = sc.nextLine();
		data.setLname(Lname);
		System.out.println("Enter email id:");
		String Email = sc.nextLine();
		data.setEmail(Email);
		System.out.println("Enter password:");
		int pass = sc.nextInt();
		data.setPassword(pass);
		System.out.println("Enter salary:");
		float sal =sc.nextFloat();
		data.setSalary(sal);
		
		boolean flag =GetConnection(data); 
		if(flag){
			System.out.println("Data insert successfully..");
		}else{
			System.out.println("Sorry can't insert data try again...");
		}
	}
	
	public static boolean GetConnection(EmployeeData data) throws SQLException{
		
		Connection conn= null;
		PreparedStatement ps = null;
		try{
				
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			String query = "insert into employee values(?,?,?,?,?)";	
			ps=conn.prepareStatement(query);
			ps.setString(1,data.getFname());
			ps.setString(2, data.getLname());
			ps.setString(3, data.getEmail());
			ps.setInt(4, data.getPassword());
			ps.setFloat(5, data.getSalary());
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
		}
		return false;
	}
}
