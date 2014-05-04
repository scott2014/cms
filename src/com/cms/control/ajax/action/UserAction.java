package com.cms.control.ajax.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.constant.Account;
import com.cms.model.entity.User;
import com.cms.model.service.UserService;
import com.cms.model.util.MDEncode;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	@Autowired
	@Resource(name="userService")
	private UserService userService;
	
	private String username;
	private String password;
	
	private long id;
	
	private boolean isExist = false;
	
	private String errorCode;
	
	public String check() {
		this.isExist = this.userService.exist(username);
		return "check";
	}
	
	public String login() throws Exception {
		User user = this.userService.checkUser(username, MDEncode.encode(password));
		if (user != null) {
			if (user.getStatus() != null && user.getStatus() == Account.NORMAL) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("user", user);
			} else {
				errorCode = "*该账户已冻结";
			}
		} else {
			this.errorCode = "*用户名或者密码错误";
		}
		return "login";
	}
	
	public String freeze() throws Exception {
		User u = this.userService.findById(id);
		u.setStatus(Account.FREEZE);
		this.userService.update(u);
		return "freeze";
	}
	
	public String release() throws Exception {
		User u = this.userService.findById(id);
		u.setStatus(Account.NORMAL);
		this.userService.update(u);
		return "release";
	}
	
	public String delete() throws Exception {
		User u = this.userService.findById(id);
		this.userService.delete(u);
		return "delete";
	}
	
	@JSON(serialize=false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
