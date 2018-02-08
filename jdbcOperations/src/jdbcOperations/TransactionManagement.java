package jdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionManagement {

	public static void main(String args[]) throws SQLException{
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Account holder name: ");
		String Ename = sc.nextLine();
		System.out.println("Enter password: ");
		int pass = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			conn.setAutoCommit(false);
			String query = "select pass from student where name=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, Ename);
			rs=ps.executeQuery();
			int password=0;
			while(rs.next()){
				password=rs.getInt(1);
			}
			
			if(password==pass){
				
				System.out.println("1:Widraw ,2:add money,3:check balance");
				int choice = sc.nextInt();
				switch(choice){
					
				case 1:	
						System.out.println("Enter widraw amount");
						double amount=sc.nextDouble();
						PreparedStatement ps1 =null;
						PreparedStatement ps2 =null;
						ResultSet rs1 = null;
						Statement st = null;
						try{
							String query1 = "select money from student where name=?";
							ps1=conn.prepareStatement(query1);
							ps1.setString(1, Ename);
							rs1=ps1.executeQuery();
							double money=0;
							while(rs1.next()){
								money =rs1.getDouble(1);
							}
							
							if(money>amount && money!=0){
									
									money =money-amount;
									String sql = "update student set money =? where name=?";
									ps2=conn.prepareStatement(sql);	
									ps2.setDouble(1, money);
									ps2.setString(2, Ename);
									int count=ps2.executeUpdate();
									if(count>0){
										Savepoint savepoint1=conn.setSavepoint("savePoint1");
										System.out.println("money widraw success and update");
									}else{
										conn.rollback();
										System.out.println("money not widraw..");
									}
							}else{
									
									System.out.println("insufficient balance");
									conn.rollback();
							}
						}catch(Exception e){
								e.printStackTrace();
						}finally{
							ps1.close();
							rs1.close();
							ps2.close();
							
						}
						break;
				case 2:
						System.out.println("Enter amount");
						double amount1 = sc.nextDouble();
						PreparedStatement ps3 = null;
						ResultSet rs3=null;
					try{
						
						String str3 = "select money from student where name=?";
						ps3=conn.prepareStatement(str3);
						ps3.setString(1, Ename);
						rs3=ps3.executeQuery();
						double money1=0;
						while(rs3.next()){
							money1 = rs3.getDouble(1);
						}
						money1=money1+amount1;
						String sql3 = "update student set money =? where name=?";
						ps3=conn.prepareStatement(sql3);	
						ps3.setDouble(1, money1);
						ps3.setString(2, Ename);
						int count=ps3.executeUpdate();
						if(count>0){
							Savepoint savePoint2=conn.setSavepoint("savePoint2");
							System.out.println("money update");
						}else{
							conn.rollback();
							System.out.println("money not update..");
						}
					
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						ps3.close();
						rs3.close();
					}
					break;
				case 3:
						PreparedStatement ps4 = null;
						ResultSet rs4 = null;
					try{	
						String str= "select money from student where name=?";
						ps4=conn.prepareStatement(str);
						ps4.setString(1, Ename);
						rs4=ps4.executeQuery();
						double balance=0;
						while(rs4.next()){
							balance=rs4.getDouble(1);
						}
						
						System.out.println("Balance is "+balance);
					
					}catch(Exception e){
						conn.rollback();
						e.printStackTrace();
					}finally{
						ps4.close();
						rs4.close();
					}	
					break;
				default:System.out.println("enter correct choice..");	
				}
			}else{
				System.out.println("password incorrect");
				
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
			rs.close();
		}
	}
}
