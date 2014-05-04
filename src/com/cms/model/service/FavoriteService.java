package com.cms.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.FavoriteDAO;
import com.cms.model.entity.Favorite;
import com.cms.model.vo.MedicinalVO;
import com.cms.model.vo.NewRepositoryVO;

@Service("favoriteService")
public class FavoriteService {
	
	@Autowired
	@Resource(name="favoriteDAO")
	private FavoriteDAO favoriteDAO;
	
	@Transactional
	public void save(Favorite favorite) {
		this.favoriteDAO.save(favorite);
	}
	
	public Favorite findById(long id) {
		return this.favoriteDAO.findById(id);
	}
	
	@Transactional
	public void update(Favorite favorite) {
		this.favoriteDAO.update(favorite);
	}
	
	@Transactional
	public Favorite findByRepoId(long repoId) {
		return this.favoriteDAO.findByRepoId(repoId);
	}
	
	public List<NewRepositoryVO> findRepoByCondition(int pageSize,int pageNum,long userId) {
		return this.favoriteDAO.findRepoByCondition(pageSize, pageNum,userId);
	}
	
	public int countRepoByCondition(long userId) {
		return this.favoriteDAO.countRepoByCondition(userId);
	}
	
	public List<MedicinalVO> findMedByCondition(int pageSize,int pageNum,long userId) {
		return this.favoriteDAO.findMedByCondition(pageSize, pageNum,userId);
	}
	
	public int countMedByCondition(long userId) {
		return this.favoriteDAO.countMedByCondition(userId);
	}
	
	@Transactional
	public void delete(Favorite favorite) {
		this.favoriteDAO.del(favorite);
	}
	
	public Favorite find(long repoId,long userId) {
		return this.favoriteDAO.find(repoId, userId);
	}
}
