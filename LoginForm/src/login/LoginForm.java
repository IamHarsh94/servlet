package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		try{
			String name =req.getParameter("uname");
			String	password=req.getParameter("pass");
			
			if(name.equals("harshal")&&password.equals("9119")){
				RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
				rd.forward(req, res);
			}else{
				pw.print("<html><body>");
				pw.print("<p style='color:red'><b>incorrect email and password<b><p>");	
				pw.print("<body><html>");
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}	
				
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
