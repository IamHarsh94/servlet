package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccount extends HttpServlet{

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try{
			String fullname =req.getParameter("fullname");
			String	username =req.getParameter("username");
			String password = req.getParameter("password");
			if(fullname.equals("")||username.equals("")||password.equals("")){
				pw.print("<html><body>");
				pw.print("<p style='color:red'><b>Enter a field first<b><p>");
				pw.print("<body><html>");
				RequestDispatcher rd =req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}else{
				RequestDispatcher rd=req.getRequestDispatcher("Account.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
	
	
}
