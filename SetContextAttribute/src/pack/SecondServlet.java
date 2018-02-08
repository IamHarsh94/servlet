package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet{
	
		public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
				res.setContentType("text/html");
				PrintWriter print = res.getWriter();
				try{
					ServletContext con=getServletContext();
					String name=String.valueOf(con.getAttribute("name"));
					int salary=Integer.valueOf((String) con.getAttribute("salary"));
					
					 print.println("name: "+name);
					 print.println("Salary: "+salary);
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					print.close();
				}
		}
}
