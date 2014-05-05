package com.cms.control.ajax.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.Medicinal;
import com.cms.model.entity.UserMedicinal;
import com.cms.model.service.MedicinalService;
import com.cms.model.service.UserMedicinalService;
import com.opensymphony.xwork2.ActionSupport;

public class MedicinalAction extends ActionSupport {
	
	@Autowired
	@Resource
	private MedicinalService medicinalService;
	
	@Autowired
	@Resource(name="userMedicinalService")
	private UserMedicinalService userMedicinalService;
	
	//删除的对应试剂Id
	private long mId;
	
	public String delete() throws Exception {
		Medicinal m = this.medicinalService.findById(mId);
		
		List<UserMedicinal> ums = this.userMedicinalService.findByMId(mId);
		if (ums != null && ums.size() > 0) {
			for (UserMedicinal um : ums) {
				this.userMedicinalService.delete(um);
			}
		}
		
		
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
