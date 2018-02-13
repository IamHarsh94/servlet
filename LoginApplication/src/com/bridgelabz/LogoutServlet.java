package com.bridgelabz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		HttpSession session = req.getSession(false);
			
			if(session!=null){
				req.setAttribute("msg", "successfully logout..");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
				return;
			}
			res.sendRedirect("login");
						
	}

		
}
