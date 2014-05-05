package com.cms.control.struts.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
	
	//申请的试剂数量
	private float applyNumber;
	
	private String mUsage;
	private String security;
	private String shape;
	private String description;
	
	public String execute() throws Exception {
		if (photo != null) {
			String rootPath = ServletActionContext.getRequest().getRealPath("/upload");
			String newFileName = System.currentTimeMillis() + "." + photoFileName.split("[.]")[1];
			
			FileUtils.copyFile(photo, new File(rootPath + "/" + newFileName));
			
			this.medicinal.setPhoto("/upload/" + newFileName);
		}
		
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		
		this.medicinal.setUserId(userId);
		this.medicinal.setCreateTime(new Date());
		
		String usage = this.medicinal.getMusage();
		String sec = this.medicinal.getSecurity();
		String sh = this.medicinal.getShape();
		String desc = this.medicinal.getDescription();
		
		if (usage != null && !usage.trim().equals("")) {
			usage = usage.replaceAll("\n", "<br/>");
			sec = sec.replaceAll("\n", "<br/>");
			sh = sh.replaceAll("\n", "<br/>");
			desc = desc.replaceAll("\n", "<br/>");
		}
		
		this.medicinal.setMusage(usage);
		this.medicinal.setSecurity(sec);
		this.medicinal.setShape(sh);
		this.medicinal.setDescription(desc);
		
		this.medicinalService.save(medicinal);
		
		return Action.SUCCESS;
	}
	
	public String toCreate() throws Exception {
		long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		this.myrepos = this.repositoryService.findByUserId(Integer.MAX_VALUE, 1, userId, null);
		return "toCreate";
	}
	
	public String load() throws Exception {
		//long userId = ((User)ServletActionContext.getRequest().getSession().getAttribute("user")).getId();
		
		if (key != null && !key.trim().equals("")) {
			key = new String(key.getBytes("iso8859-1"),"utf-8");
		}
		
		this.totalCount = this.medicinalService.countByCondition(key);
		
		this.pageCount = this.totalCount % pageSize == 0 ? this.totalCount / pageSize : this.totalCount / pageSize + 1;
		
		this.medicinals = this.medicinalService.findByCondition(pageSize, pageNum, key);
		
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
		
		String usage1 = m.getMusage();
		String security1 = m.getSecurity();
		String shape1 = m.getShape();
		String desc1 = m.getDescription();
		
		if (usage1 != null && !usage1.trim().equals("")) {
			this.mUsage = usage1.replaceAll("<br/>", "\n");
		}
		
		if (security1 != null && !security1.trim().equals("")) {
			this.security = security1.replaceAll("<br/>", "\n");
		}
		
		if (shape1 != null && !shape1.trim().equals("")) {
			this.shape = shape1.replace("<br/>", "\n");
		}
		
		if (desc1 != null && !desc1.trim().equals("")) {
			this.description = desc1.replaceAll("<br/>", "\n");
		}
		
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
			User u = this.userService.findById(m.getUserId());
			
			ApplyMedicinalVO umVO = new ApplyMedicinalVO();
			umVO.setMedicinal(m);
			umVO.setUserMedicinal(um);
			umVO.setUser(u);
			
			applys.add(umVO);
		}
		
		return "myApply";
	}
	
	public String update() throws Exception {
		Medicinal m = this.medicinalService.findById(id);
		
		m.setFormula(medicinal.getFormula());
		m.setName(medicinal.getName());
		m.setCas(medicinal.getCas());
		
		String shape1 = medicinal.getShape();
		String musage1 = medicinal.getMusage();
		String security1 = medicinal.getSecurity();
		String description1 = medicinal.getDescription();
		
		if (shape1 != null && !shape1.trim().equals("")) {
			shape1 = shape1.replaceAll("\n", "<br/>");
		}
		
		if (musage1 != null && !musage1.trim().equals("")) {
			musage1 = musage1.replaceAll("\n", "<br/>");
		}
		
		if (security1 != null && !security1.trim().equals("")) {
			security1 = security1.replaceAll("\n", "<br/>");
		}
		
		if (description1 != null && !description1.trim().equals("")) {
			description1 = description1.replaceAll("\n", "<br/>");
		}
		
		m.setShape(shape1);
		m.setMusage(musage1);
		m.setSecurity(security1);
		m.setDescription(description1);
		
		m.setStandard(medicinal.getStandard());
		m.setNo(medicinal.getNo());
		m.setLeft(medicinal.getLeft());
		
		if (photo != null) {
			String rootPath = ServletActionContext.getRequest().getRealPath("/upload");
			String newFileName = System.currentTimeMillis() + "." + photoFileName.split("[.]")[1];
			
			FileUtils.copyFile(photo, new File(rootPath + "/" + newFileName));
			
			m.setPhoto("/upload/" + newFileName);
		}
		
		this.medicinalService.update(m);
		
		return "update";
	}
	
	public String apply() throws Exception {
		UserMedicinal um = new UserMedicinal();
		
		um.setApplyNumber(applyNumber);
		um.setApplyTime(new Date());
		um.setMedicinalId(id);
		um.setStatus(Check.NOT_APPROVE);
		
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		um.setUserId(u.getId());
		
		Medicinal m = this.medicinalService.findById(um.getMedicinalId());
		um.setAppId(m.getUserId());
		um.setCheckTime(new Date());
		this.userMedicinalService.save(um);
		
		return "apply";
	}
	
	public String tgApply() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u1 = (User) session.getAttribute("user");
		
		List<UserMedicinal> ums = this.userMedicinalService.find(u1.getId(), Check.APPROVED);
		
		for (UserMedicinal um : ums) {
			Medicinal m  = this.medicinalService.findById(um.getMedicinalId());
			User u = this.userService.findById(m.getUserId());
			
			ApplyMedicinalVO umVO = new ApplyMedicinalVO();
			umVO.setMedicinal(m);
			umVO.setUserMedicinal(um);
			umVO.setUser(u);
			
			applys.add(umVO);
		}
		return "tgApply";
	}
	
	public String rfApply() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u1 = (User) session.getAttribute("user");
		
		List<UserMedicinal> ums = this.userMedicinalService.find(u1.getId(), Check.REFUSED);
		
		for (UserMedicinal um : ums) {
			Medicinal m  = this.medicinalService.findById(um.getMedicinalId());
			User u = this.userService.findById(m.getUserId());
			
			ApplyMedicinalVO umVO = new ApplyMedicinalVO();
			umVO.setMedicinal(m);
			umVO.setUserMedicinal(um);
			umVO.setUser(u);
			
			applys.add(umVO);
		}
		return "rfApply";
	}
	
	//审核通过后获取到的所有试剂
	public String appliedMedicinal() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u1 = (User) session.getAttribute("user");
		
		List<UserMedicinal> ums = this.userMedicinalService.find(u1.getId(), Check.APPROVED);
		
		for (UserMedicinal um : ums) {
			Medicinal m  = this.medicinalService.findById(um.getMedicinalId());
			User u = this.userService.findById(m.getUserId());
			
			ApplyMedicinalVO umVO = new ApplyMedicinalVO();
			umVO.setMedicinal(m);
			umVO.setUserMedicinal(um);
			umVO.setUser(u);
			
			applys.add(umVO);
		}
		return "appliedMedicinal";
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

	public float getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(float applyNumber) {
		this.applyNumber = applyNumber;
	}

	public MedicinalVO getmVO() {
		return mVO;
	}

	public void setmVO(MedicinalVO mVO) {
		this.mVO = mVO;
	}

	public String getMUsage() {
		return mUsage;
	}

	public void setMUsage(String mUsage) {
		this.mUsage = mUsage;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
