package com.cms.control.ajax.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.service.RepositoryService;
import com.opensymphony.xwork2.ActionSupport;

public class RepositoryAction extends ActionSupport {
	
	@Autowired
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	private long id;
	
	private boolean ok = false; 
	
	public String delete() throws Exception {
		this.ok = this.repositoryService.delById(id);
		return "delete";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
