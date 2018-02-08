package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletInterface implements Servlet{
	
	ServletConfig config = null;
	
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Config object created...");
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				pw.print("<html><body>");
				pw.println("<b>Service method running...<b>");
				pw.print("<b>here we write logical part<b>");
				pw.print("<body><html>");
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();
			}
	}

	public String getServletInfo() {
		
		return "Servlet info";
	}
	public ServletConfig getServletConfig() {
		
		return config;
	}
	@Override
	public void destroy() {
		System.out.println("Servlet destroyed..");
		
	}
	
}
