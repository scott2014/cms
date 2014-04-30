package com.cms.control.ajax.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.Favorite;
import com.cms.model.entity.User;
import com.cms.model.service.FavoriteService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FavoriteAction extends ActionSupport {
	
	@Autowired      
	@Resource(name="favoriteService")
	private FavoriteService favoriteService;
	
	private long repositoryId = -1;
	private long medicinalId = -1;
	
	private  String errorCode = "成功加入收藏夹";
	
	private long id;
	
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		
		Favorite f = this.favoriteService.findByRepoId(repositoryId);
		
		if (f == null) {
			Favorite f1 = new Favorite();
			f1.setRepositoryId(repositoryId);
			f1.setUserId(user.getId());
			f1.setCreateTime(new Date());
			this.favoriteService.save(f1);
		} else {
			this.errorCode = "该试剂库已经存在于收藏夹";
		}
		
		return Action.SUCCESS;
	}

	public String delete() throws Exception {
		Favorite f = this.favoriteService.findByRepoId(id);
		
		if (f != null) this.favoriteService.delete(f);
		return "delete";
	}
	
	public long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		this.repositoryId = repositoryId;
	}

	public long getMedicinalId() {
		return medicinalId;
	}

	public void setMedicinalId(long medicinalId) {
		this.medicinalId = medicinalId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
