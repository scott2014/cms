package com.cms.control.struts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.model.entity.User;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String requestUrl = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		
		User u = (User) session.getAttribute("user");
		if (requestUrl.contains(".jsp") && !requestUrl.contains("login.jsp") && u == null) {
			if (requestUrl.contains("register.jsp")) {
				chain.doFilter(req, res);
			} else {
				try {
					res.sendRedirect(req.getContextPath() + "/login/login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
