package com.cms.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="_right",catalog="cms")
public class Right implements java.io.Serializable {
	private Integer id;
	private int rightCode;
	private String rightName;
	private List<User> users;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToMany(targetEntity=com.cms.model.entity.User.class,mappedBy="rights")
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Column(name="rightCode",length=4)
	public int getRightCode() {
		return rightCode;
	}
	public void setRightCode(int rightCode) {
		this.rightCode = rightCode;
	}
	
	@Column(name="rightName",length=16)
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	
	
}
