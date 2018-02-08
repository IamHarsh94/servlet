package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutData extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException{
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				HttpSession session =req.getSession(false);
				if(session !=null){
						String name = (String) session.getAttribute("uname");
						pw.print("<html><body>");
						pw.print("<b> "+name+" logout successfully.. <b>");
						pw.print("<a href='index.html'>Home</a>");
						pw.print("<body><html>");
						session.invalidate();
					
				}else{
					pw.print("<html><body>");
					pw.print("<p style='color:red'>login first..<b><p>");
					pw.print("<body><html>");
					
					RequestDispatcher rd =req.getRequestDispatcher("login.html");
					rd.include(req, res);
				}	
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();			
			}
	}
}
