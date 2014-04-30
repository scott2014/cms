package com.cms.model.dao;

import java.util.List;

import com.cms.model.entity.Repository;


public interface RepositoryDAO {
	public void save(Repository repository);

	public void del(Repository repository);

	public void update(Repository repository);

	public Repository findById(long id);

	public boolean delById(long id);

	public List<Repository> load(final int pageSize,final int pageNum,String key);
	
	public int totalCount(String key);
	
	public List<Repository> findByUserId(final int pageSize,final int pageNum,String key,long userId);
	
	public int countByUserId(long userId,String key);
}
