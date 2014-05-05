package com.cms.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.RepositoryDAO;
import com.cms.model.dao.UserDAO;
import com.cms.model.entity.Repository;
import com.cms.model.entity.User;
import com.cms.model.vo.RepositoryVO;

@Service("repositoryService")
public class RepositoryService {
	
	@Autowired
	@Resource(name="repositoryDAO")
	private RepositoryDAO repositoryDAO;
	
	@Autowired
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Transactional
	public void save(RepositoryVO repositoryVO) {
		Repository repo = new Repository();
		repo.setRepoNo(repositoryVO.getRepoNo());
		repo.setRepoName(repositoryVO.getRepoName());
		repo.setUserId(repositoryVO.getUserId());
		repo.setDepartment(repositoryVO.getDepartment());
		repo.setAddress(repositoryVO.getAddress());
		this.repositoryDAO.save(repo);
		
		User user = this.userDAO.findById(repositoryVO.getUserId());
		user.setEmail(repositoryVO.getEmail());
		user.setPhone(repositoryVO.getPhone());
		user.setQq(repositoryVO.getQq());
		this.userDAO.update(user);
	}
	
	@Transactional
	public List<RepositoryVO> load(int pageNum,int pageSize,String key) {
		List<Repository> repos = this.repositoryDAO.load(pageSize, pageNum, key);
		
		List<RepositoryVO> result = new ArrayList<RepositoryVO>();
		
		
		if (repos != null && repos.size() > 0) {
			for (Repository r : repos) {
				RepositoryVO repoVO = new RepositoryVO();
				repoVO.setRepoId(r.getId());
				repoVO.setAddress(r.getAddress());
				repoVO.setDepartment(r.getDepartment());
				repoVO.setRepoNo(r.getRepoNo());
				repoVO.setRepoName(r.getRepoName());
				repoVO.setCreateTime(r.getCreateTime());
				
				User u = this.userDAO.findById(r.getUserId());
				repoVO.setUserId(u.getId());
				repoVO.setUsername(u.getUsername());
				repoVO.setEmail(u.getEmail());
				repoVO.setQq(u.getQq());
				repoVO.setPhone(u.getPhone());
				repoVO.setRealName(u.getRealName());
				
				result.add(repoVO);
			}
		}
		
		
		return result;
	}
	
	@Transactional
	public Repository findById(long id) {
		return this.repositoryDAO.findById(id);
	}
	
	public int totalCount(String key) {
		return this.repositoryDAO.totalCount(key);
	}
	
	public boolean delById(long id) {
		return this.repositoryDAO.delById(id);
	}
	
	@Transactional
	public void update(Repository repository) {
		this.repositoryDAO.update(repository);
	}
	
	public List<Repository> findByUserId(int pageSize,int pageNum,long userId,String key) {
		return this.repositoryDAO.findByUserId(pageSize, pageNum, key, userId);
	}
	
	public int countByUserId(long userId,String key) {
		return this.repositoryDAO.countByUserId(userId, key);
	}
	
	@Transactional
	public void save(Repository repository) {
		this.repositoryDAO.save(repository);
	}
}
