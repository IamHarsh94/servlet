package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myservlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		try{
			System.out.println(pw);
			pw.print("<br>In servlet<br>");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			/*pw.close();*/
		}
	} 
}
