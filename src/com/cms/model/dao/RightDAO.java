package com.cms.model.dao;

import com.cms.model.entity.Right;

public interface RightDAO {
	public void save(Right right);

	public void del(Right right);

	public void update(Right right);

	public Right findById(int id);

	public void delById(int id);

}
