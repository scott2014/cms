package com.cms.model.vo;

import com.cms.model.entity.User;

//该类用户处理用户在描述中输入的换行符
public class UserVO {
	private User user;
	private String description;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
