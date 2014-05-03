package com.cms.control.struts.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cms.model.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class LoginInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		User u = (User) session.getAttribute("user");
		String actionName = invocation.getAction().getClass().getSimpleName();
		String methodName = invocation.getProxy().getMethod();
		
		if (u == null) {
			if (actionName.equals("UserAction") && (   methodName.equals("login") 
													   || methodName.equals("register")
													   || methodName.equals("check"))) {
				invocation.invoke();
				return null;
			} else {
				response.sendRedirect(request.getContextPath() + "/login/login.jsp");
				return null;
			}
		}
		invocation.invoke();
		return null;
	}

	

}
