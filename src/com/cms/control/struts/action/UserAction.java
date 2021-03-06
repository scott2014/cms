package com.cms.control.struts.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
import com.cms.model.vo.UserVO;
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
	
	private long id;
	
	private String suffix;
	
	private UserVO userVO = new UserVO();
	
	private int totalCount;
	private int pageSize = 5;
	private int pageCount = 0;
	private int pageNum = 1;
	
	public String register() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(MDEncode.encode(password));
		
		List<Right> rs = new ArrayList<Right>();
		Right r = this.rightService.findById(2);
		rs.add(r);
		user.setRights(rs);
		
		user.setStatus(Account.NORMAL);
		user.setRegisterTime(new Date());
		
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
		this.totalCount = this.userService.countByRightCode(UserRight.STUDENT);
		
		this.pageCount = this.totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		this.users = this.userService.findByRightCode(UserRight.STUDENT, pageSize, pageNum);
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
		u.setEmail(user.getEmail() + suffix);
		u.setQq(user.getQq());
		u.setPhone(user.getPhone());
		u.setUniversity(user.getUniversity());
		u.setDepartment(user.getDepartment());
		u.setFaculty(user.getFaculty());
		
		String desc = user.getDescription();
		desc = desc.replaceAll("\n", "<br/>");
		
		u.setDescription(desc);
		u.setAddress(user.getAddress());
		
		this.userService.update(u);
		
		User uu = this.userService.findById(u.getId());
		ServletActionContext.getRequest().getSession().setAttribute("user", uu);
		return "updateInfo";
	}
	
	public String showInfo() throws Exception {
		this.user = this.userService.findById(id);
		return "showInfo";
	}
	
	public String toUpdateInfo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		
		this.userVO.setUser(u);
		
		String desc = u.getDescription();
		if (desc != null && !desc.trim().equals("")) {
			desc = desc.replaceAll("<br/>", "\n");
		}
		
		this.userVO.setDescription(desc);
		return "toUpdateInfo";
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
	
}
