package com.bridgelabz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet{

		public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
			
				RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
				rd.forward(req, res);
				return;
		}
}