package com.cms.model.vo;

import java.util.Date;
import java.util.List;

import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.entity.User;

public class NewRepositoryVO {
	private Repository repository;
	private User user;
	private List<Medicinal> medicinals;
	private Date lastViewTime;
	
	public Repository getRepository() {
		return repository;
	}
	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Medicinal> getMedicinals() {
		return medicinals;
	}
	public void setMedicinals(List<Medicinal> medicinals) {
		this.medicinals = medicinals;
	}
	
	public Date getLastViewTime() {
		return lastViewTime;
	}
	public void setLastViewTime(Date lastViewTime) {
		this.lastViewTime = lastViewTime;
	}
}
