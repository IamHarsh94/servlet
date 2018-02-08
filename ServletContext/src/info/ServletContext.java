package info;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class ServletContext extends HttpServlet{
	
	public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException{
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				javax.servlet.ServletContext context=getServletContext();
				int salary= Integer.valueOf(context.getInitParameter("salary"));
				int year = Integer.valueOf(context.getInitParameter("year"));
				pw.println("<b>In servlet one<b><br>");
				pw.print("Salary is: "+salary);
				pw.print(" Year is "+year);
				pw.print("<html><body>");
				pw.print(" <a href='second'>Move to second servlet</a>");
				pw.print("<body><html>");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();
			}
	}
}
