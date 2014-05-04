package com.cms.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.HistoryDAO;
import com.cms.model.entity.Favorite;
import com.cms.model.entity.History;
import com.cms.model.vo.MedicinalVO;
import com.cms.model.vo.NewRepositoryVO;

@Service("historyService")
public class HistoryService {
	
	@Autowired
	@Resource(name="historyDAO")
	private HistoryDAO historyDAO;
	
	@Transactional
	public void saveOrUpdate(History history) {
		this.historyDAO.saveOrUpdate(history);
	}
	
	
	@Transactional
	public History findById(long id) {
		return this.historyDAO.findById(id);
	}
	
	@Transactional
	public void save(History history) {
		this.historyDAO.save(history);
	}
	
	public History findByRepoId(long repoId) {
		return this.historyDAO.findByRepoId(repoId);
	}
	
	public History findByMedId(long mid) {
		return this.historyDAO.findByMedId(mid);
	}
	
	@Transactional
	public void update(History history) {
		this.historyDAO.update(history);
	}
	
	public List<NewRepositoryVO> findRepoByCondition(int pageSize,int pageNum,long userId) {
		return this.historyDAO.findRepoByCondition(pageSize, pageNum,userId);
	}
	
	public int countRepoByCondition(long userId) {
		return this.historyDAO.countRepoByCondition(userId);
	}
	
	public List<MedicinalVO> findMedByCondition(int pageSize,int pageNum,long userId) {
		return this.historyDAO.findMedByCondition(pageSize, pageNum,userId);
	}
	
	public int countMedByCondition(long userId) {
		return this.historyDAO.countMedByCondition(userId);
	}
	
	public History find(long repoId,long userId) {
		return this.historyDAO.find(repoId,userId);
	}
}
