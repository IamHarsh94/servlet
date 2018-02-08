package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw =res.getWriter();
		try{
			String name = req.getParameter("uname");
			pw.print("<b>Welcome in servlet second: "+name+"<b>");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
	
}
