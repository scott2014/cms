package com.cms.control.ajax.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
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
	@Resource(name="medicinalService")
	private MedicinalService medicinalService;
	
	private long id;
	
	private int status;
	
	private String errorCode;
	
	public String update() throws Exception {
		UserMedicinal um = this.userMedicinalService.findById(id);
		
		Medicinal m = this.medicinalService.findById(um.getMedicinalId());
		
		float left = m.getLeft();
		float applyNumber = um.getApplyNumber();
		
		if (applyNumber - left > 0) {
			errorCode = "试剂存量不足，请先修改试剂存量";
		} else {
			um.setStatus(status);
			
			if (status == Check.APPROVED) {
				m.setLeft(m.getLeft() - um.getApplyNumber());
				this.medicinalService.update(m);
			}
			this.userMedicinalService.update(um);
			
			errorCode = "";
		}
		
		return "update";
	}
	
	@JSON(serialize=false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
