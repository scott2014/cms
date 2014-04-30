package com.cms.control.struts.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.User;
import com.cms.model.service.HistoryService;
import com.cms.model.vo.MedicinalVO;
import com.cms.model.vo.NewRepositoryVO;
import com.opensymphony.xwork2.ActionSupport;

public class HistoryAction extends ActionSupport {
	
	@Autowired
	@Resource(name="historyService")
	private HistoryService historyService;
	
	private long repositoryId = -1;
	private long medicinalId = -1;
	
	//浏览过的试剂库
	private List<NewRepositoryVO> repos;
	//浏览过过的试剂
	private List<MedicinalVO> ms;
	
	//试剂库分页参数
	private int rtotalCount;
	private int rpageSize = 5;
	private int rpageCount = 1;
	private int rpageNum = 1;
	
	//试剂分页参数
	private int mtotalCount;
	private int mpageSize = 5;
	private int mpageCount = 1;
	private int mpageNum = 1;
	
	
	public String load() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		
		this.rtotalCount = this.historyService.countRepoByCondition(user.getId());
		this.rpageCount = this.rtotalCount % rpageSize == 0 ? this.rtotalCount / rpageSize : this.rtotalCount / rpageSize + 1;
		
		this.repos = this.historyService.findRepoByCondition(rpageSize, rpageNum,user.getId());
		
		this.mtotalCount = this.historyService.countMedByCondition(user.getId());
		this.mpageCount = this.mtotalCount % mpageSize == 0 ? this.mtotalCount / mpageSize : this.mtotalCount / mpageSize + 1;
		
		this.ms = this.historyService.findMedByCondition(mpageSize, mpageNum,user.getId());
		
		return "load";
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


	public List<NewRepositoryVO> getRepos() {
		return repos;
	}


	public void setRepos(List<NewRepositoryVO> repos) {
		this.repos = repos;
	}


	public List<MedicinalVO> getMs() {
		return ms;
	}


	public void setMs(List<MedicinalVO> ms) {
		this.ms = ms;
	}


	public int getRtotalCount() {
		return rtotalCount;
	}


	public void setRtotalCount(int rtotalCount) {
		this.rtotalCount = rtotalCount;
	}


	public int getRpageSize() {
		return rpageSize;
	}


	public void setRpageSize(int rpageSize) {
		this.rpageSize = rpageSize;
	}


	public int getRpageCount() {
		return rpageCount;
	}


	public void setRpageCount(int rpageCount) {
		this.rpageCount = rpageCount;
	}


	public int getRpageNum() {
		return rpageNum;
	}


	public void setRpageNum(int rpageNum) {
		this.rpageNum = rpageNum;
	}


	public int getMtotalCount() {
		return mtotalCount;
	}


	public void setMtotalCount(int mtotalCount) {
		this.mtotalCount = mtotalCount;
	}


	public int getMpageSize() {
		return mpageSize;
	}


	public void setMpageSize(int mpageSize) {
		this.mpageSize = mpageSize;
	}


	public int getMpageCount() {
		return mpageCount;
	}


	public void setMpageCount(int mpageCount) {
		this.mpageCount = mpageCount;
	}


	public int getMpageNum() {
		return mpageNum;
	}


	public void setMpageNum(int mpageNum) {
		this.mpageNum = mpageNum;
	}
}
