package com.cms.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="_right",catalog="cms")
public class Right {
	private Integer id;
	private List<User> users;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToMany(targetEntity=com.cms.model.entity.User.class,
		    fetch=FetchType.LAZY,cascade={CascadeType.REMOVE})
    @JoinTable(name="user_right",
	joinColumns=@JoinColumn(name="rightId"),
	inverseJoinColumns=@JoinColumn(name="userId"))
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
