package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAtrribute extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				
				String name = req.getParameter("ename");
				pw.println("In servlet one:");
				pw.println("name : "+name+" is set to the session");
				HttpSession session=req.getSession();
				session.setAttribute("ename", name);
				pw.print("<html><body>");
				pw.print("<a href='second'>To second servlet</a>");
				pw.print("<body><html>");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();
			}
	}
}
