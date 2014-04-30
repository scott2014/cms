package com.cms.model.vo;

import com.cms.model.entity.Medicinal;
import com.cms.model.entity.UserMedicinal;

public class ApplyMedicinalVO {
	private Medicinal medicinal;
	private UserMedicinal userMedicinal;
	
	public Medicinal getMedicinal() {
		return medicinal;
	}
	public void setMedicinal(Medicinal medicinal) {
		this.medicinal = medicinal;
	}
	public UserMedicinal getUserMedicinal() {
		return userMedicinal;
	}
	public void setUserMedicinal(UserMedicinal userMedicinal) {
		this.userMedicinal = userMedicinal;
	}
}
