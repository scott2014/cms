package com.cms.model.vo;

import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.entity.User;

public class MedicinalVO {
	private Medicinal medicinal;
	private Repository repository;
	private User user;
	
	public Medicinal getMedicinal() {
		return medicinal;
	}
	public void setMedicinal(Medicinal medicinal) {
		this.medicinal = medicinal;
	}
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
}
