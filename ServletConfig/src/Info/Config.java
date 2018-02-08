package Info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Config extends HttpServlet{
	
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
			
			res.setContentType("text/html");
			PrintWriter pw =res.getWriter();
			try{
				ServletConfig config=getServletConfig();
				int salary = Integer.valueOf(config.getInitParameter("salary"));	
				int year = Integer.valueOf(config.getInitParameter("year"));
							
				RequestDispatcher obj = req.getRequestDispatcher("result.jsp");
				obj.forward(req, res);
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pw.close();
			}
		}
}
