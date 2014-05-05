package com.cms.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.MedicinalDAO;
import com.cms.model.dao.RepositoryDAO;
import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.vo.MedicinalVO;

@org.springframework.stereotype.Repository("medicinalDAO")
public class MedicinalDAOImpl implements MedicinalDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Resource(name="repositoryDAO")
	private RepositoryDAO repositoryDAO;

	public void save(Medicinal m) {
		this.hibernateTemplate.save(m);
	}

	public void del(Medicinal m) {
		this.hibernateTemplate.delete(m);
	}

	public void update(Medicinal m) {
		this.hibernateTemplate.update(m);
	}

	public Medicinal findById(long id) {
		String hql = "from Medicinal where id = ?";
		List<Medicinal> result = this.hibernateTemplate.find(hql,id);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}

	public void delById(long id) {
		// TODO Auto-generated method stub
		
	}

	public List<Medicinal> loadAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(Medicinal.class);
	}

	public List<MedicinalVO> findByCondition(int pageSize, int pageNum, String key,long userId) {
		List<MedicinalVO> result = new ArrayList<MedicinalVO>();
		
		List<Medicinal> all = this.findByUserId(userId);
		
		if (all != null && all.size() > 0) {
			for (Medicinal m : all) {
				Repository p = this.repositoryDAO.findById(m.getRepositoryId());
				if (key != null && !key.trim().equals("")) {
					if ((m.getName() != null && m.getName().contains(key)) || (p.getRepoName() != null && p.getRepoName().contains(key))) {
						MedicinalVO mv = new MedicinalVO(); 
						mv.setMedicinal(m);
						mv.setRepository(p);
						result.add(mv);
					}
				}
				if (key == null || key.trim().equals("")) {
					MedicinalVO mv = new MedicinalVO(); 
					mv.setMedicinal(m);
					mv.setRepository(p);
					result.add(mv);
				}
			}
		}
		
		
		List<MedicinalVO> res = new ArrayList<MedicinalVO>();
		if (result.size() > 0) {
			int temp = (pageNum-1)*pageSize+pageSize;
			int length = result.size();
			int end = temp > length ? length : temp ;
			for (int i=(pageNum-1)*pageSize;i<end;i++) {
				res.add(result.get(i));
			}
		}
		
		return res;
	}

	public int countByCondition(String key,long userId) {
		int count = 0;
		
		List<Medicinal> all = this.findByUserId(userId);
		
		if (all != null && all.size() > 0) {
			for (Medicinal m : all) {
				Repository p = this.repositoryDAO.findById(m.getRepositoryId());
				if (key != null && !key.trim().equals("")) {
					if ((m.getName() != null && m.getName().toLowerCase().contains(key.toLowerCase())) || (p.getRepoName() != null && p.getRepoName().toLowerCase().contains(key.toLowerCase())))  count ++;
				}
				if (key == null || key.trim().equals("")) {
					count ++;
				}
			}
		}
		return count;
	}

	
	public List<MedicinalVO> findByCondition(int pageSize, int pageNum, String key) {
		List<MedicinalVO> result = new ArrayList<MedicinalVO>();
		
		List<Medicinal> all = this.loadAll();
		
		if (all != null && all.size() > 0) {
			for (Medicinal m : all) {
				Repository p = this.repositoryDAO.findById(m.getRepositoryId());
				if (key != null && !key.trim().equals("")) {
					if ((m.getName() != null && m.getName().toLowerCase().contains(key.toLowerCase())) 
																		|| (p.getRepoName() != null && p.getRepoName().toLowerCase().contains(key.toLowerCase()))
																		|| (m.getFormula() != null && m.getFormula().toLowerCase().contains(key.toLowerCase()))) {
						MedicinalVO mv = new MedicinalVO(); 
						mv.setMedicinal(m);
						mv.setRepository(p);
						result.add(mv);
					}
				}
				if (key == null || key.trim().equals("")) {
					MedicinalVO mv = new MedicinalVO(); 
					mv.setMedicinal(m);
					mv.setRepository(p);
					result.add(mv);
				}
			}
		}
		
		
		List<MedicinalVO> res = new ArrayList<MedicinalVO>();
		if (result.size() > 0) {
			int temp = (pageNum-1)*pageSize+pageSize;
			int length = result.size();
			int end = temp > length ? length : temp ;
			for (int i=(pageNum-1)*pageSize;i<end;i++) {
				res.add(result.get(i));
			}
		}
		
		return res;
	}

	public int countByCondition(String key) {
		int count = 0;
		
		List<Medicinal> all = this.loadAll();
		
		if (all != null && all.size() > 0) {
			for (Medicinal m : all) {
				Repository p = this.repositoryDAO.findById(m.getRepositoryId());
				if (key != null && !key.trim().equals("")) {
					if ((m.getName() != null && m.getName().contains(key)) 
							                                              || (p.getRepoName() != null && p.getRepoName().contains(key))
							                                              || (m.getFormula() != null && m.getFormula().contains(key)))  count ++;
				}
				if (key == null || key.trim().equals("")) {
					count ++;
				}
			}
		}
		return count;
	}
	
	public List<Medicinal> findByUserId(long userId) {
		String hql = "from Medicinal where userId = ?";
		return this.hibernateTemplate.find(hql,userId);
	}
	
	public List<Medicinal> findByRepoId(final int pageSize,final int pageNum, final long repoId) {
		final String hql = "from Medicinal where repositoryId = ?";
		
		List<Medicinal> result = this.hibernateTemplate.executeFind(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNum - 1) * pageSize);
				query.setMaxResults(pageSize);
				query.setLong(0, repoId);
				return query.list();
			}
			
		});
		return result;
	}
	
	public int countByRepoId(long repoId) {
		final String hql = "select count(*) from Medicinal where repositoryId = ?";
		
		List<Long> result = this.hibernateTemplate.find(hql,repoId);
		return result != null && result.size() > 0 ? result.get(0).intValue() : null;
	}
	
}
