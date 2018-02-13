package com.bridgelabz;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {

		System.out.println("Filter initialize");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;

		HttpSession session = req.getSession(false);
		if(session==null){
			res.sendRedirect("login");
			return;
		}
			
		
		chain.doFilter(req, res);
	
	}

	public void destroy() {
		System.out.println("filter destroyed..");
	}
}
