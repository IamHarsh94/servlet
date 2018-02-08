package jdbcOperations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CollableStatement {

	public static void main(String args[]) throws SQLException{
		Scanner sc = new Scanner(System.in); 
		EmployeeData emp = new EmployeeData();
		System.out.println("Enter first name who's salary you want to change :");
		String name = sc.nextLine();
		emp.setFname(name);
		System.out.println("Enter salary :");
		float sal = sc.nextFloat();
		emp.setSalary(sal);
		boolean flag = add(emp);
		if(flag){
			System.out.println("Successfuly update..");
		}else{
			System.out.println("Not update try again..");
		}
	}
	public static boolean add(EmployeeData emp) throws SQLException{
		Connection conn =null;
		CallableStatement call =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			call = conn.prepareCall("call updateFirstName(?,?)");
			call.setString(1, emp.getFname());
			call.setFloat(2, emp.getSalary());
			call.executeUpdate();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			call.close();
			conn.close();
			
		}
		return false;
		
	}
}
