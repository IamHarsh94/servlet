package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.awt.datatransfer.DataTransferer.ReencodingInputStream;

public class SecondServlet extends HttpServlet{
	
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
				
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				try{
					HttpSession session=req.getSession(false);
					String name =String.valueOf(session.getAttribute("ename"));
					pw.print("<html><body>");
					pw.print("<b>Welcome "+name+" to second servlet<b>");
					pw.print("<body><html>");
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					pw.close();
				}
		}
}
