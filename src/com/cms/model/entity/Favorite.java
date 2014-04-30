package com.cms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "favorite", catalog = "cms")
public class Favorite implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long repositoryId;
	private Long medicinalId;
	private Date createTime;

	// Constructors

	/** default constructor */
	public Favorite() {
	}

	/** full constructor */
	public Favorite(Long userId, Long repositoryId) {
		this.userId = userId;
		this.repositoryId = repositoryId;
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

	@Column(name = "userId")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "repositoryId")
	public Long getRepositoryId() {
		return this.repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	@Column(name = "medicinalId",length=64)
	public Long getMedicinalId() {
		return medicinalId;
	}

	public void setMedicinalId(Long medicinalId) {
		this.medicinalId = medicinalId;
	}
	
	@Column(name="createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}