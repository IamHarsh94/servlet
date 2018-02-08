package info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Myfilter implements Filter{
	
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter initialize");
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		
			PrintWriter pw =res.getWriter();
			pw.println("filter invoked before/");
			System.out.println(pw);
			chain.doFilter(req,res);
			pw.println("filter invoked after");
			System.out.println("hello " + pw);
	}
	
	public void destroy() {
		System.out.println("filter distroyed");
	}

}
