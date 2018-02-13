package com.bridgelabz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
		
		RequestDispatcher rd =req.getRequestDispatcher("register.jsp");
		rd.forward(req, res);
		return;
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		String username=req.getParameter("Uname");
		String password=req.getParameter("Pass");
				
		 Regexvalidaton valid = new Regexvalidaton();
		 
		 if(!(valid.validatePassword(password)&&valid.ValidateEmail(username))){
			 res.sendRedirect("register");
			 System.out.println("somthing wrong in pass & username");
			 return;
		 }
		
		
			HttpSession session = req.getSession();
			
		try{
			String id=req.getParameter("userId");
			String Fname = req.getParameter("Fname");
			String Lname=req.getParameter("Lname");
			String Uname=req.getParameter("Uname");
			String pass=req.getParameter("Pass");
			session.setAttribute("Uname", Uname);
			Dao obj = new Dao();
			LoginData info = new LoginData();
				info.setId(id);
				info.setFname(Fname);
				info.setLname(Lname);
				info.setUname(Uname);
				info.setPass(pass);
				
				if(obj.insertInfo(info)){
					res.sendRedirect("result");
					return;
				}
				
				res.sendRedirect("prereg");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}

}
