package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	
	 MyPoolConnectionClass instance = MyPoolConnectionClass.getInstance();
	
	public boolean userAuth(FormData data) throws SQLException {

		Connection conn = null;
		PreparedStatement pd = null;
		ResultSet rt = null;
		String username = null;
		String password = null;
		String firstname=null;
		boolean flag = false;
		try {
			conn=instance.getConnection();
		
			String sql = "select username,password,firstname from user where username=?";
			pd = conn.prepareStatement(sql);
			pd.setString(1, data.getUserName());
			rt = pd.executeQuery();
			
			while(rt.next()){
				data.setFirstName(rt.getString("firstname"));
				data.setUserName(rt.getString("username"));
				data.setPassWord(rt.getString("password"));
				flag=true;
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			rt.close();
			pd.close();
			conn.close();
		}
		return flag;
	}
	
	
	public boolean insertInfo(LoginData info) throws SQLException{
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pd =null;
		int rt = 0;
		try {
				
			conn=instance.getConnection();
			
			String sql = "insert into user(id,firstname,lastname,username,password)values(?,?,?,?,?)";
			pd = conn.prepareStatement(sql);
			
			pd.setString(1, info.getId());
			pd.setString(2, info.getFname());
			pd.setString(3, info.getLname());
			pd.setString(4, info.getUname());
			pd.setString(5, info.getPass());
			
			rt = pd.executeUpdate();
			if(rt>0){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pd.close();
			conn.close();
		}
		return flag;
	}
}
