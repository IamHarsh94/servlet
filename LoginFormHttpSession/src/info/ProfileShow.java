package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileShow extends HttpServlet{
	
		
		public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
				res.setContentType("text/html");
				PrintWriter pw =res.getWriter();
				try{
					HttpSession session=req.getSession(false);
					if(session!=null){
						RequestDispatcher rd =req.getRequestDispatcher("mapping.html");
						rd.include(req, res);
						String name =(String) session.getAttribute("uname");
						pw.print("<html><body>");
						pw.print("Hello "+name+" welcome to your profile...");
						pw.print("<body><html>");
					}else{
						pw.print("<html><body>");
						pw.println("<p style='color:red'>Login first...<p>");
						pw.print("<body><html>");
						RequestDispatcher rd=req.getRequestDispatcher("login.html");
						rd.include(req, res);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					pw.close();
				}
		}
}
