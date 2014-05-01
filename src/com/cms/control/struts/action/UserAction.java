package com.cms.control.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.Right;
import com.cms.model.entity.User;
import com.cms.model.service.RightService;
import com.cms.model.service.UserService;
import com.cms.model.util.MDEncode;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	@Autowired
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	@Resource(name="rightService")
	private RightService rightService;
	
	private String username;
	private String password;
	
	private String errorCode;
	
	public String register() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(MDEncode.encode(password));
		
		List<Right> rs = new ArrayList<Right>();
		Right r = this.rightService.findById(2);
		rs.add(r);
		user.setRights(rs);
		
		this.userService.save(user);
		return "register";
	}
	
	public String login() {
		User user = this.userService.checkUser(username, MDEncode.encode(password));
		if (user != null) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			return "login";
		} else {
			this.errorCode = "*用户名或者密码错误";
			return "fail";
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
