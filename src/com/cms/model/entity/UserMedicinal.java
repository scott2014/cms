package com.cms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_medicinal",catalog="cms")
public class UserMedicinal implements java.io.Serializable {
	
	private long id;
	private long userId;
	private long medicinalId;
	private int status;
	private Date checkTime;
	private Date applyTime;
	private Float applyNumber;
	private Long appId;
	private Integer advice;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="userId",length=64)
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Column(name="medicinalId",length=64)
	public long getMedicinalId() {
		return medicinalId;
	}
	public void setMedicinalId(long medicinalId) {
		this.medicinalId = medicinalId;
	}
	
	@Column(name="status",length=4)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="checkTime")
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	
	@Column(name="applyTime")
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	@Column(name="applyNumber",length=10)
	public Float getApplyNumber() {
		return applyNumber;
	}
	public void setApplyNumber(Float applyNumber) {
		this.applyNumber = applyNumber;
	}
	
	@Column(name="appId",length=64)
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	
	@Column(name="advice",length=4)
	public Integer getAdvice() {
		return advice;
	}
	public void setAdvice(Integer advice) {
		this.advice = advice;
	}
	
	
}
