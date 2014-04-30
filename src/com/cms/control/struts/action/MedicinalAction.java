package com.cms.control.struts.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

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
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class MedicinalAction extends ActionSupport {
	
	@Autowired
	@Resource(name="medicinalService")
	private MedicinalService medicinalService;
	
	
	@Autowired
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	@Autowired
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	@Resource(name="userMedicinalService")
	private UserMedicinalService userMedicinalService;
	
	private long id;
	
	private File photo;
	private String photoFileName;
	private String photoContentType;
	
	private Medicinal medicinal;
	
	private List<Repository> myrepos;
	
	private List<MedicinalVO> medicinals;
	
	private int pageSize = 5;
	private int pageNum = 1;
	private int pageCount = 0;
	private int totalCount = 0;
	
	private String key = null;
	
	private List<MedicinalVO> myme;
	
	private MedicinalVO mVO = new MedicinalVO();
	
	//申请的试剂
	private List<ApplyMedicinalVO> applys = new ArrayList<ApplyMedicinalVO>();
	
	public String execute() throws Exception {
		System.out.println(medicinal);
		
		String rootPath = ServletActionContext.getRequest().getRealPath("/upload");
		String newFileName = System.currentTimeMillis() + "." + photoFileName.split("[.]")[1];
		
		FileUtils.copyFile(photo, new File(rootPath + "/" + newFileName));
		
		this.medicinal.setPhoto("/upload/" + newFileName);
		
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		
		this.medicinal.setUserId(userId);
		this.medicinal.setCreateTime(new Date());
		
		this.medicinalService.save(medicinal);
		
		return Action.SUCCESS;
	}
	
	public String toCreate() throws Exception {
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		this.myrepos = this.repositoryService.findByUserId(Integer.MAX_VALUE, 1, userId, null);
		return "toCreate";
	}
	
	public String load() throws Exception {
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		
		this.totalCount = this.medicinalService.countByCondition(key,userId);
		
		this.pageCount = this.totalCount % pageSize == 0 ? this.totalCount / pageSize : this.totalCount / pageSize + 1;
		
		this.medicinals = this.medicinalService.findByCondition(pageSize, pageNum, key,userId);
		
		return "load";
	}
	
	public String loadMe() throws Exception {
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		this.myrepos = this.repositoryService.findByUserId(Integer.MAX_VALUE, 1, userId, null);
		
		this.totalCount = this.medicinalService.countByCondition(key, userId);
		
		this.pageCount = this.totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		this.myme = this.medicinalService.findByCondition(pageSize, pageNum, key, userId);
		
		return "loadMe";
	}
	
	public String toUpdate() throws Exception {
		Medicinal m = this.medicinalService.findById(id);
		Repository p = this.repositoryService.findById(m.getRepositoryId());
		
		this.mVO.setMedicinal(m);
		this.mVO.setRepository(p);
		
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		this.myrepos = this.repositoryService.findByUserId(Integer.MAX_VALUE, 1, userId, null);
		return "toUpdate";
	}
	
	public String toDetail() throws Exception {
		Medicinal m = this.medicinalService.findById(id);
		Repository p = this.repositoryService.findById(m.getRepositoryId());
		
		this.mVO.setMedicinal(m);
		this.mVO.setRepository(p);
		
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		this.mVO.setUser(user);
		
		return "toDetail";
	}
	
	public String toApply() throws Exception {
		Medicinal m = this.medicinalService.findById(id);
		Repository p = this.repositoryService.findById(m.getRepositoryId());
		User u = this.userService.findById(m.getUserId());
		
		mVO.setMedicinal(m);
		mVO.setRepository(p);
		mVO.setUser(u);
		
		return "toApply";
	}
	
	public String myApply() throws Exception {
		List<UserMedicinal> ums = this.userMedicinalService.findAll();
		
		for (UserMedicinal um : ums) {
			Medicinal m  = this.medicinalService.findById(um.getMedicinalId());
			
			ApplyMedicinalVO umVO = new ApplyMedicinalVO();
			umVO.setMedicinal(m);
			umVO.setUserMedicinal(um);
			
			applys.add(umVO);
		}
		
		return "myApply";
	}
	
	public String update() throws Exception {
		return "update";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Medicinal getMedicinal() {
		return medicinal;
	}

	public void setMedicinal(Medicinal medicinal) {
		this.medicinal = medicinal;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public List<Repository> getMyrepos() {
		return myrepos;
	}

	public void setMyrepos(List<Repository> myrepos) {
		this.myrepos = myrepos;
	}

	public List<MedicinalVO> getMedicinals() {
		return medicinals;
	}

	public void setMedicinals(List<MedicinalVO> medicinals) {
		this.medicinals = medicinals;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<MedicinalVO> getMyme() {
		return myme;
	}

	public void setMyme(List<MedicinalVO> myme) {
		this.myme = myme;
	}

	public MedicinalVO getMVO() {
		return mVO;
	}

	public void setMVO(MedicinalVO mVO) {
		this.mVO = mVO;
	}

	public List<ApplyMedicinalVO> getApplys() {
		return applys;
	}

	public void setApplys(List<ApplyMedicinalVO> applys) {
		this.applys = applys;
	}
}
