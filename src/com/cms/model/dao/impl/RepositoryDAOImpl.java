package com.cms.model.dao.impl;

import java.sql.SQLException;
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

@org.springframework.stereotype.Repository("repositoryDAO")
public class RepositoryDAOImpl implements RepositoryDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Resource(name="medicinalDAO")
	private MedicinalDAO medicinalDAO;
	
	public void save(Repository repository) {
		this.hibernateTemplate.save(repository);
	}

	public void del(Repository repository) {
		this.hibernateTemplate.delete(repository);
	}

	public void update(Repository repository) {
		this.hibernateTemplate.update(repository);
	}

	public Repository findById(long id) {
		return this.hibernateTemplate.get(Repository.class, id);
	}
	
	@Transactional
	public boolean delById(long id) {
		try {
			Repository repo = this.findById(id);
			this.del(repo);
			
			List<Medicinal> ms = this.medicinalDAO.findByRepoId(Integer.MAX_VALUE, 1, repo.getId());
			for (Medicinal m : ms) {
				this.medicinalDAO.del(m);
			}
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public List<Repository> load(final int pageSize,final int pageNum,String key) {
		String hql = "from Repository";
		if (key != null && !key.trim().equals("")) {
			hql += " where department like '%" + key + "%' or address like '%" + key + "%' or repoName like '%" + key + "%'"
					+ " or repoNo like '%" + key + "%' ";
		}
		
		final String hql1 = hql;
		List<Repository> result = this.hibernateTemplate.executeFind(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setMaxResults(pageSize).setFirstResult((pageNum-1)*pageSize);
				return query.list();
			}
		});
		
		return result;
	}
	
	public int totalCount(String key) {
		String hql = "select count(id) from Repository";
		if (key != null && !key.trim().equals("")) {
			hql += " where department like '%" + key + "%' or address like '%" + key + "%' or repoName like '%" + key + "%'";
		}
		
		return ((Long)this.hibernateTemplate.find(hql).get(0)).intValue();
	}

	public List<Repository> findByUserId(final int pageSize,final int pageNum, String key,long userId) {
		String hql = "from Repository where userId=" + userId;
		if (key != null && !key.trim().equals("")) {
			hql += " and (department like '%" + key + "%' or address like '%" + key + "%' or repoName like '%" + key + "%')";
		}
		final String hql1 = hql;
		List<Repository> result = this.hibernateTemplate.executeFind(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				query.setMaxResults(pageSize).setFirstResult((pageNum-1)*pageSize);
				return query.list();
			}
		});
		
		return result;
	}

	public int countByUserId(long userId, String key) {
		String hql = "select count(id) from Repository where userId=" + userId;
		if (key != null && !key.trim().equals("")) {
			hql += " and (department like '%" + key + "%' or address like '%" + key + "%' or repoName like '%" + key + "%')";
		}
		return ((Long)this.hibernateTemplate.find(hql).get(0)).intValue();
	}
	
}
