package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginData extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				
				String name=req.getParameter("uname");
				String pass=req.getParameter("pass");
				
				if(name.equals("")||pass.equals("")){
					pw.print("<html><body>");
					pw.print("<p style='color:red'><b>Field must not empty..<b><p>");
					pw.print("<body><html>");
					RequestDispatcher rd=req.getRequestDispatcher("login.html");
					rd.include(req, res);
				}else{
					RequestDispatcher rd =req.getRequestDispatcher("mapping.html");	
					rd.include(req, res);
				
					
					HttpSession	session=req.getSession();
					session.setAttribute("uname", name);
					pw.println("");
					pw.print("<html><body>");
					pw.print("<b>Successfully login: "+name+"<b>");
					pw.print("<body><html>");

					
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();
			}
	}
	
}
