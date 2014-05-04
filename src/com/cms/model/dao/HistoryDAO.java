package com.cms.model.dao;

import java.util.List;

import com.cms.model.entity.History;
import com.cms.model.vo.MedicinalVO;
import com.cms.model.vo.NewRepositoryVO;

public interface HistoryDAO {
	public void save(History history);

	public void del(History history);

	public void update(History history);

	public History findById(long id);

	public void delById(long id);

	public List<History> loadAll();
	
	public void saveOrUpdate(History history);
	
	public History findByRepoId(long repoId);
	
	public History findByMedId(long mid);
	
	public List<NewRepositoryVO> findRepoByCondition(int pageSize,int pageNum,long userId);
	
	public int countRepoByCondition(long userId);
	
	public List<MedicinalVO> findMedByCondition(int pageSize,int pageNum,long userId);
	
	public int countMedByCondition(long userId);
	
	public History find(long repoId,long userId);
}
