package com.cms.control.struts.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.constant.Account;
import com.cms.model.constant.UserRight;
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
	
	private List<User> users;
	
	private User user = null;
	
	private File photo;
	private String photoFileName;
	private String photoContentType;
	
	public String register() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(MDEncode.encode(password));
		
		List<Right> rs = new ArrayList<Right>();
		Right r = this.rightService.findById(2);
		rs.add(r);
		user.setRights(rs);
		
		user.setStatus(Account.NORMAL);
		
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
	
	public String mgr() throws Exception {
		this.users = this.userService.findRyRightCode(UserRight.STUDENT);
		return "mgr";
	}
	
	public String loginOut() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		/*Enumeration em = session.getAttributeNames();
		
		while (em.hasMoreElements()) {
			if (em.nextElement().toString().equals("user")) {
				session.removeAttribute("user");
			}
		}*/
		
		session.removeAttribute("user");
		session.setAttribute("user", null);
		
		session.invalidate();
		return "loginOut";
	}
	
	public String updateInfo() throws Exception {
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if (photo != null) {
			String rootPath = ServletActionContext.getRequest().getRealPath("/upload");
			String newFileName = System.currentTimeMillis() + "." + this.photoFileName.split("[.]")[1];
			FileUtils.copyFile(photo, new File(rootPath + "/" + newFileName));
			u.setPhoto("/upload/" + newFileName);
		}
		
		u.setRealName(user.getRealName());
		u.setEmail(user.getEmail());
		u.setQq(user.getQq());
		u.setPhone(user.getPhone());
		u.setUniversity(user.getUniversity());
		u.setDepartment(user.getDepartment());
		u.setFaculty(user.getFaculty());
		u.setDescription(user.getDescription());
		u.setAddress(user.getAddress());
		
		this.userService.update(u);
		
		User uu = this.userService.findById(u.getId());
		ServletActionContext.getRequest().getSession().setAttribute("user", uu);
		return "updateInfo";
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
}
