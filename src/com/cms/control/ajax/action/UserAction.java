package com.cms.control.ajax.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.constant.Account;
import com.cms.model.entity.Favorite;
import com.cms.model.entity.History;
import com.cms.model.entity.User;
import com.cms.model.service.FavoriteService;
import com.cms.model.service.HistoryService;
import com.cms.model.service.UserService;
import com.cms.model.util.MDEncode;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	@Autowired
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	@Resource(name="historyService")
	private HistoryService historyService;
	
	@Autowired
	@Resource(name="favoriteService")
	private FavoriteService favoriteService;
	
	private String username;
	private String password;
	
	private long id;
	
	private boolean isExist = false;
	
	private String errorCode;
	
	private String oldPass;
	private String newPass;
	
	public String check() {
		this.isExist = this.userService.exist(username);
		return "check";
	}
	
	public String login() throws Exception {
		User user = this.userService.checkUser(username, MDEncode.encode(password));
		if (user != null) {
			if (user.getStatus() != null && user.getStatus() == Account.NORMAL) {
				user.setLastLogin(new Date());
				this.userService.update(user);
				
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
		
		//同时删除该用户的收藏和历史记录
		List<History> hs = this.historyService.findByUserId(u.getId());
		for (History h : hs) {
			this.historyService.delete(h);
		}
	
		List<Favorite> fs = this.favoriteService.findByUserId(u.getId());
		for (Favorite f : fs) {
			this.favoriteService.delete(f);
		}
		
		this.userService.delete(u);
		
	
		return "delete";
	}
	
	public String updatePass() throws Exception {
		User u = this.userService.findById(id);
		
		if (!u.getPassword().equals(MDEncode.encode(oldPass))) {
			errorCode = "*原密码不正确";
		} else {
			u.setPassword(MDEncode.encode(newPass));
			this.userService.update(u);
			errorCode = "密码修改成功";
		}
		return "updatePass";
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

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
}
