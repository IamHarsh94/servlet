package com.bridgelabz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.Dao;
import com.bridgelabz.FormData;
import com.bridgelabz.Regexvalidaton;
public class LoginServlet extends HttpServlet{


	
	public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException, ServletException{
		
		RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
		rd.forward(req, res);
		return;
		
	} 
	@SuppressWarnings("static-access")
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
				
		 Regexvalidaton valid = new Regexvalidaton();
		 
		 if(!(valid.validatePassword(pass)&&valid.ValidateEmail(uname))){
			 res.sendRedirect("login");
			 System.out.println("somthing wrong in pass & username");
			 return;
		 }
		
		FormData data=new FormData();
		Dao connect = new Dao();
		
		data.setUserName(uname);
		data.setPassWord(pass);
		HttpSession session=req.getSession();

		try {
			if(connect.userAuth(data))
			{
				session.setAttribute("username", data.getUserName());
				session.setAttribute("firstname",data.getFirstName());
				res.sendRedirect("welcome");
				return;
			}else{
				req.setAttribute("msg", "Invalid Credential/create account first");
				res.sendRedirect("login");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		
}
	
}
