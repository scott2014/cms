package com.cms.control.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.constant.Check;
import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.entity.User;
import com.cms.model.entity.UserMedicinal;
import com.cms.model.service.MedicinalService;
import com.cms.model.service.RepositoryService;
import com.cms.model.service.UserMedicinalService;
import com.cms.model.service.UserService;
import com.cms.model.vo.ApplyMedicinalVO;
import com.cms.model.vo.MedicinalVO;
import com.opensymphony.xwork2.ActionSupport;

public class UserMedicinalAction extends ActionSupport {
	
	@Autowired
	@Resource(name="userMedicinalService")
	private UserMedicinalService userMedicinalService;
	
	@Autowired
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	@Resource(name="medicinalService")
	private MedicinalService medicinalService;
	
	@Autowired
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	private MedicinalVO mVO = new MedicinalVO();
	
	private List<ApplyMedicinalVO> amVOs = new ArrayList<ApplyMedicinalVO>();
	
	private long id;
	
	private int status;
	
	public String check() throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<UserMedicinal> ums = this.userMedicinalService.findByAppId(user.getId());
		
		for (UserMedicinal um : ums) {
			ApplyMedicinalVO amvo = new ApplyMedicinalVO();
			amvo.setMedicinal(this.medicinalService.findById(um.getMedicinalId()));
			
			User u = this.userService.findById(um.getUserId());
			amvo.setUser(u);
			
			amvo.setUserMedicinal(um);
			this.amVOs.add(amvo);
		}
		return "check";
	}
	
	public String toCheck() throws Exception {
		UserMedicinal um = this.userMedicinalService.findById(id);
		
		Medicinal m = this.medicinalService.findById(um.getMedicinalId());
		User u = this.userService.findById(m.getUserId());
		Repository r = this.repositoryService.findById(m.getRepositoryId());
		
		mVO.setMedicinal(m);
		mVO.setRepository(r);
		mVO.setUser(u);
		return "toCheck";
	}

	public String update() throws Exception {
		UserMedicinal um = this.userMedicinalService.findById(id);
		
		um.setStatus(status);
		
		if (status == Check.APPROVED) {
			Medicinal m = this.medicinalService.findById(um.getMedicinalId());
			m.setLeft(m.getLeft() - um.getApplyNumber());
			this.medicinalService.update(m);
		}
		
		this.userMedicinalService.update(um);
		return "update";
	}
	
	public List<ApplyMedicinalVO> getAmVOs() {
		return amVOs;
	}

	public void setAmVOs(List<ApplyMedicinalVO> amVOs) {
		this.amVOs = amVOs;
	}

	public MedicinalVO getMVO() {
		return mVO;
	}

	public void setMVO(MedicinalVO mVO) {
		this.mVO = mVO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
