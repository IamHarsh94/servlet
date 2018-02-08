package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet{
	
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
			
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				pw.print("<html><body>");
				pw.print("<b>Welcome to second servlet <b>");
				pw.print("<body><html>");
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();
			}
		}
}
