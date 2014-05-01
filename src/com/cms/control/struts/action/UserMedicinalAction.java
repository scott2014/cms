package com.cms.control.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.User;
import com.cms.model.entity.UserMedicinal;
import com.cms.model.service.MedicinalService;
import com.cms.model.service.UserMedicinalService;
import com.cms.model.service.UserService;
import com.cms.model.vo.ApplyMedicinalVO;
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
	
	private List<ApplyMedicinalVO> amVOs = new ArrayList<ApplyMedicinalVO>();
	
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

	public List<ApplyMedicinalVO> getAmVOs() {
		return amVOs;
	}

	public void setAmVOs(List<ApplyMedicinalVO> amVOs) {
		this.amVOs = amVOs;
	}
}
