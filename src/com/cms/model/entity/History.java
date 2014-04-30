package com.cms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * History entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "history", catalog = "cms")
public class History implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long repositoryId;
	private Long medicinalId;
	private Date lastViewTime;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** full constructor */
	public History(Long userId, Long repositoryId, Long medicinalId) {
		this.userId = userId;
		this.repositoryId = repositoryId;
		this.medicinalId = medicinalId;
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

	@Column(name = "medicinalId")
	public Long getMedicinalId() {
		return this.medicinalId;
	}

	public void setMedicinalId(Long medicinalId) {
		this.medicinalId = medicinalId;
	}
	
	@Column(name="lastViewTime")
	public Date getLastViewTime() {
		return lastViewTime;
	}

	public void setLastViewTime(Date lastViewTime) {
		this.lastViewTime = lastViewTime;
	}
}