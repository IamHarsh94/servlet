package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException{
		
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		try{
			String ename=req.getParameter("uname");
			String pass = req.getParameter("pass");
			if(ename.equals("harshal")&&pass.equals("harshal")){
				pw.print("<html><body>");
				pw.print("<b>Email and Password correct...<b>");
				pw.print("<body><html>");
			}else{
				pw.print("<html><body>");
				pw.print("<b>Plz enter correct email and password...<b>");
				pw.print("<a href='index.html'>try again</a>");
				pw.print("<body><html>");
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
