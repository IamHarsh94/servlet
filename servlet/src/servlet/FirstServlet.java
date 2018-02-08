package servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter fw=res.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try{
			if(username.equals("harshal")&&password.equals("harshal")){
				fw.write("<html><body><b>Login success<b><body></html>");
			}else{
				fw.write("<html><body><b>Login faild<b><body><html>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fw.close();
		}
		
		
	}

	
	
}
