package com.cms.control.ajax.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.Medicinal;
import com.cms.model.service.MedicinalService;
import com.opensymphony.xwork2.ActionSupport;

public class MedicinalAction extends ActionSupport {
	
	@Autowired
	@Resource
	private MedicinalService medicinalService;
	
	//删除的对应试剂Id
	private long mId;
	
	public String delete() throws Exception {
		Medicinal m = this.medicinalService.findById(mId);
		
		this.medicinalService.delete(m);
		return "delete";
	}

	public long getMId() {
		return mId;
	}

	public void setMId(long mId) {
		this.mId = mId;
	}
}
