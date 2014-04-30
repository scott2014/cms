package com.cms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Medicinal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "medicinal", catalog = "cms")
public class Medicinal implements java.io.Serializable {

	// Fields

	private Long id;
	private String formula;
	private String name;
	private String cas;
	private String shape;
	private String musage;
	private String security;
	private String standard;
	private Long repositoryId;
	private String photo;
	//试剂编号
	private String no;
	private String description;
	private long userId;
	private Date createTime;
	
	private int left;

	// Constructors

	/** default constructor */
	public Medicinal() {
	}

	/** full constructor */
	public Medicinal(String formula, String name, String cas, String shape,
			String musage, String security, String standard, Long repositoryId,String photo,String no,String description) {
		this.formula = formula;
		this.name = name;
		this.cas = cas;
		this.shape = shape;
		this.musage = musage;
		this.security = security;
		this.standard = standard;
		this.repositoryId = repositoryId;
		this.photo = photo;
		this.no = no;
		this.description = description;
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

	@Column(name = "formula", length = 64)
	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Column(name = "name", length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cas", length = 16)
	public String getCas() {
		return this.cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	@Column(name = "shape", length = 16)
	public String getShape() {
		return this.shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Column(name = "mUsage", length = 16)
	public String getMusage() {
		return this.musage;
	}

	public void setMusage(String musage) {
		this.musage = musage;
	}

	@Column(name = "security", length = 32)
	public String getSecurity() {
		return this.security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	@Column(name = "standard", length = 32)
	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Column(name = "repositoryId")
	public Long getRepositoryId() {
		return this.repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	@Column(name="photo",length=255)
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Column(name="no",length=100)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@Column(name="description",length=255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="userId",length=64)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Column(name="createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="left",length=32)
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}
	
	
}