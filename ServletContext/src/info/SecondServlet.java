package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
			
				res.setContentType("text/html");
				PrintWriter pw =res.getWriter();
				try{
					javax.servlet.ServletContext con =getServletContext();
					int salary = Integer.valueOf(con.getInitParameter("salary"));
					int year = Integer.valueOf(con.getInitParameter("year"));
					pw.println("<b>In servlet second<b><br>");
					pw.println(" Salary is: "+salary);
					pw.println(" year is: "+year);
				}catch(Exception e){
					e.printStackTrace();	
				}finally{
					pw.close();
				}
		}
}
