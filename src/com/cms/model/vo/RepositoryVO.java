package com.cms.model.vo;

import java.util.Date;

public class RepositoryVO {
	private long repoId;
	private String repoNo;
	private String repoName;
	private String department;
	private String address;
	private String email;
	private String phone;
	private String qq;
	private long userId;
	private String username;
	private String realName;
	private int stored = 0;
	private Date createTime;
	
	public long getRepoId() {
		return repoId;
	}
	public void setRepoId(long repoId) {
		this.repoId = repoId;
	}
	public String getRepoNo() {
		return repoNo;
	}
	public void setRepoNo(String repoNo) {
		this.repoNo = repoNo;
	}
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getStored() {
		return stored;
	}
	public void setStored(int stored) {
		this.stored = stored;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
