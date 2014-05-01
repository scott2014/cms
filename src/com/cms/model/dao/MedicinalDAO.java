package com.cms.model.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cms.model.entity.Medicinal;
import com.cms.model.vo.MedicinalVO;

public interface MedicinalDAO {
	public void save(Medicinal m);

	public void del(Medicinal m);

	public void update(Medicinal m);

	public Medicinal findById(long id);

	public void delById(long id);

	public List<Medicinal> loadAll();

	public List<MedicinalVO> findByCondition(int pageSize,int pageNum,String key,long userId);

	public int countByCondition(String key,long userId);
	
	public List<Medicinal> findByUserId(long userId);
	
	public List<Medicinal> findByRepoId(int pageSize,int pageNum,long repoId);
	
	public int countByRepoId(long repoId);
	
	public List<MedicinalVO> findByCondition(int pageSize,int pageNum,String key);
	
	public int countByCondition(String key);
}
