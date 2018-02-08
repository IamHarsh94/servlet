package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter	pw=res.getWriter();
		
			String name=req.getParameter("uname");
			String pass =req.getParameter("pass");
		try{
				if(name.equals("harshal")&&pass.equals("harshal")){
					RequestDispatcher rd =req.getRequestDispatcher("servlet2");
					rd.forward(req, res);
				}else{
					pw.print("Wrong email and password");
					RequestDispatcher rd =req.getRequestDispatcher("index.html");
					rd.include(req, res);
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}

	
}
