package com.bridgelabz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PreWelcomeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		HttpSession session =req.getSession(false);
		String firstname =(String) session.getAttribute("firstname");
		req.setAttribute("firstname",firstname);
		RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
		rd.forward(req, resp);
		return;
	}
}
