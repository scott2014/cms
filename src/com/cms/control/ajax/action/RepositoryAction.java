package com.cms.control.ajax.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.Favorite;
import com.cms.model.entity.History;
import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.entity.UserMedicinal;
import com.cms.model.service.FavoriteService;
import com.cms.model.service.HistoryService;
import com.cms.model.service.MedicinalService;
import com.cms.model.service.RepositoryService;
import com.cms.model.service.UserMedicinalService;
import com.opensymphony.xwork2.ActionSupport;

public class RepositoryAction extends ActionSupport {
	
	@Autowired
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	@Autowired
	@Resource(name="medicinalService")
	private MedicinalService medicinalService;
	
	@Autowired
	@Resource(name="historyService")
	private HistoryService historyService;
	
	@Autowired
	@Resource(name="favoriteService")
	private FavoriteService favoriteService;
	
	@Autowired
	@Resource(name="userMedicinalService")
	private UserMedicinalService userMedicinalService;
	
	private long id;
	
	private boolean ok = false; 
	
	public String delete() throws Exception {
		Repository r = this.repositoryService.findById(id);
		//同时删除在该试剂库下的所有试剂记录
		List<Medicinal> ms = this.medicinalService.findByRepoId(Integer.MAX_VALUE, 1, r.getId());
		for (Medicinal m : ms) {
			this.medicinalService.delete(m);
		}
		//删除相关的所有历史记录和收藏
		List<History> hs = this.historyService.findByRepoId(id);
		for (History h : hs) {
			this.historyService.delete(h);
		}
		
		Favorite f = this.favoriteService.findByRepoId(id);
		if (f != null) {
			this.favoriteService.delete(f);
		}
		
		List<UserMedicinal> ums = this.userMedicinalService.findAll();
		if (ums != null && ums.size() > 0) {
			for (UserMedicinal um : ums) {
				Medicinal m = this.medicinalService.findById(um.getMedicinalId());
				if (m.getRepositoryId() == id) {
					this.medicinalService.delete(m);
				}
			}
		}
		
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
