package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

public class SetcontextParam extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		try{
			ServletContext con =getServletContext();
			con.setAttribute("name","harshal");
			con.setAttribute("salary","10000");
			pw.println("In first servlet value is set in attribute");
			pw.print("<html><body>");
			pw.print("<a href='servlet2'>To second servlet<a>");
			pw.print("<body><html>");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
