package com.cms.model.dao;

import java.util.List;

import com.cms.model.entity.Favorite;
import com.cms.model.vo.MedicinalVO;
import com.cms.model.vo.NewRepositoryVO;

public interface FavoriteDAO {
	public void save(Favorite favorite);

	public void del(Favorite favorite);

	public void update(Favorite favorite);

	public Favorite findById(long id);

	public void delById(int id);

	public List<Favorite> loadAll();
	
	public Favorite findByRepoId(long repoId);
	
	public List<NewRepositoryVO> findRepoByCondition(int pageSize,int pageNum,long userId);
	
	public int countRepoByCondition(long userId);
	
	public List<MedicinalVO> findMedByCondition(int pageSize,int pageNum,long userId);
	
	public int countMedByCondition(long userId);
	
	public Favorite find(long repoId,long userId);
}
