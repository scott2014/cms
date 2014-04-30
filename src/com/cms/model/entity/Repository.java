package com.cms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Repository entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "repository", catalog = "cms")
public class Repository implements java.io.Serializable {

	// Fields

	private Long id;
	private String repoNo;
	private String department;
	private String address;
	private Long userId;
	
	private String repoName;

	// Constructors

	/** default constructor */
	public Repository() {
	}

	/** full constructor */
	public Repository(String repoNo, String department, String address,
			Long userId) {
		this.repoNo = repoNo;
		this.department = department;
		this.address = address;
		this.userId = userId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "repoNo", length = 16)
	public String getRepoNo() {
		return this.repoNo;
	}

	public void setRepoNo(String repoNo) {
		this.repoNo = repoNo;
	}

	@Column(name = "department", length = 16)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "userId")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="repoName",length=64)
	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
}