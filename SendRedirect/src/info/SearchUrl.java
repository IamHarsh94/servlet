package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchUrl extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		try{
			String url =req.getParameter("url");
			if(url.equals("")){
				pw.print("<html><body>");
				pw.print("<p style='color:red'>field must not empty<p>");
				pw.print("<body><html>");
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}else{
				
				res.sendRedirect("https://www.google.co.in/#q="+url);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
}
