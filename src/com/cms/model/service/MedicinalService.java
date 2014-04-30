package com.cms.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.MedicinalDAO;
import com.cms.model.entity.Medicinal;
import com.cms.model.vo.MedicinalVO;

@Service("medicinalService")
public class MedicinalService {
	
	@Autowired
	@Resource(name="medicinalDAO")
	private MedicinalDAO medicinalDAO;
	
	@Transactional
	public void update(Medicinal medicinal) {
		this.medicinalDAO.update(medicinal);
	}
	
	@Transactional
	public void save(Medicinal medicinal) {
		this.medicinalDAO.save(medicinal);
	}
	
	@Transactional
	public List<MedicinalVO> findByCondition(int pageSize,int pageNum,String key,long userId) {
		return this.medicinalDAO.findByCondition(pageSize, pageNum, key,userId);
	}
	
	@Transactional
	public int countByCondition(String key,long userId) {
		return this.medicinalDAO.countByCondition(key,userId);
	}
	
	@Transactional
	public void delete(Medicinal m) {
		this.medicinalDAO.del(m);
	}
	
	@Transactional
	public Medicinal findById(long id) {
		return this.medicinalDAO.findById(id);
	}
	
	@Transactional
	public List<Medicinal> findByRepoId(int pageSize,int pageNum,long id) {
		return this.medicinalDAO.findByRepoId(pageSize, pageNum, id);
	}
	
	@Transactional
	public int countByRepoId(long id) {
		return this.medicinalDAO.countByRepoId(id);
	}
}
