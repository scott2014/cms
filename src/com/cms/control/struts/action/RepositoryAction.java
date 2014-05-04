package com.cms.control.struts.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.model.entity.History;
import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.entity.User;
import com.cms.model.service.HistoryService;
import com.cms.model.service.MedicinalService;
import com.cms.model.service.RepositoryService;
import com.cms.model.service.UserService;
import com.cms.model.vo.NewRepositoryVO;
import com.cms.model.vo.RepositoryVO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RepositoryAction extends ActionSupport {
	
	@Autowired
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	@Autowired
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	@Resource(name="medicinalService")
	private MedicinalService medicinalService;
	
	@Autowired
	@Resource(name="historyService")
	private HistoryService historyService;
	
	private RepositoryVO repositoryVO;
	
	private List<RepositoryVO> repos;
	
	private long id;
	
	private int pageNum = 1;
	private int pageSize = 5;
	private int totalCount;
	private int pageCount;
	
	//搜索关键词
	private String key;
	
	private Repository repository;
	
	//需要修改的属性
	private String repoNo;
	private String repoName;
	private String department;
	private String address;
	private String university;
	private String faculty;
	private String team;
	private String fields;
	private String advice;
	
	//我的试剂库
	private List<Repository> myrepos;
	
	private User user;
	
	//试剂库详情对象
	private NewRepositoryVO nRepoVO = new NewRepositoryVO();
	
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		
		this.repository.setUserId(user.getId());
		this.repository.setCreateTime(new Date());
		this.repositoryService.save(repository);
		
		return Action.SUCCESS;
	}

	public String load() throws Exception {
		if (key != null && !key.trim().equals("")) {
			this.key = new String(key.getBytes("iso8859-1"),"utf-8");
		}
		this.repos = this.repositoryService.load(pageNum, pageSize, key);
		
		this.totalCount = this.repositoryService.totalCount(key);
		
		if (totalCount > 0) {
			pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		}
		
		return "load";
	}
	
	public String loadById() throws Exception {
		this.repository = this.repositoryService.findById(id);
		return "loadById";
	}
	
	public String update() throws Exception {
		this.repository = this.repositoryService.findById(id);
		
		this.repository.setAddress(address);
		this.repository.setDepartment(department);
		this.repository.setRepoName(repoName);
		this.repository.setRepoNo(repoNo);
		this.repository.setUniversity(university);
		this.repository.setFaculty(faculty);
		this.repository.setTeam(team);
		this.repository.setAdvice(advice);
		
		this.repositoryService.update(repository);
		return "update";
	}
	
	public String myrepo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		this.myrepos = this.repositoryService.findByUserId(pageSize, pageNum, u.getId(), key);
		
		this.totalCount = this.repositoryService.countByUserId(u.getId(), key);
		
		this.pageCount = this.totalCount % pageSize == 0 ? this.totalCount / pageSize : this.totalCount / pageSize + 1;
		
		return "myrepo";
	}
	
	public String showDetail() throws Exception {
		
		Repository p = this.repositoryService.findById(id);
		User u = this.userService.findById(p.getUserId());
		
		List<Medicinal> ms = this.medicinalService.findByRepoId(pageSize, pageNum, p.getId());
		
		this.totalCount = this.medicinalService.countByRepoId(id);
		
		this.pageCount = this.totalCount % pageSize == 0 ? this.totalCount / pageSize : this.totalCount / pageSize + 1;
		
		this.nRepoVO.setMedicinals(ms);
		this.nRepoVO.setRepository(p);
		this.nRepoVO.setUser(u);
		
		History h = this.historyService.findByRepoId(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		Date nd = formatter.parse(formatter.format(d));
		
		if (h == null) {
			History history = new History();
			history.setRepositoryId(p.getId());
			history.setLastViewTime(nd);
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			User u1 = (User) session.getAttribute("user");
			
			history.setUserId(u1.getId());
			this.historyService.save(history);
		} else {
			this.historyService.update(h);
		}
		
		return "showDetail";
	}
	
	public String toCreate() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		
		this.user = this.userService.findById(user.getId());
		return "toCreate";
	}
	
	public RepositoryVO getRepositoryVO() {
		return repositoryVO;
	}

	public void setRepositoryVO(RepositoryVO repositoryVO) {
		this.repositoryVO = repositoryVO;
	}

	public List<RepositoryVO> getRepos() {
		return repos;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRepos(List<RepositoryVO> repos) {
		this.repos = repos;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public String getRepoNo() {
		return repoNo;
	}

	public void setRepoNo(String repoNo) {
		this.repoNo = repoNo;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Repository> getMyrepos() {
		return myrepos;
	}

	public void setMyrepos(List<Repository> myrepos) {
		this.myrepos = myrepos;
	}

	public NewRepositoryVO getNRepoVO() {
		return nRepoVO;
	}

	public void setNRepoVO(NewRepositoryVO nRepoVO) {
		this.nRepoVO = nRepoVO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
}
