package com.cms.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cms.model.dao.FavoriteDAO;
import com.cms.model.dao.MedicinalDAO;
import com.cms.model.dao.RepositoryDAO;
import com.cms.model.entity.Favorite;
import com.cms.model.entity.Medicinal;
import com.cms.model.entity.Repository;
import com.cms.model.entity.User;
import com.cms.model.vo.MedicinalVO;
import com.cms.model.vo.NewRepositoryVO;

@org.springframework.stereotype.Repository("favoriteDAO")
public class FavoriteDAOImpl implements FavoriteDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Resource(name="repositoryDAO")
	private RepositoryDAO repositoryDAO;
	
	@Autowired
	@Resource(name="medicinalDAO")
	private MedicinalDAO medicinalDAO;
	
	public void save(Favorite favorite) {
		this.hibernateTemplate.save(favorite);
	}

	public void del(Favorite favorite) {
		this.hibernateTemplate.delete(favorite);
	}

	public void update(Favorite favorite) {
		
	}

	public Favorite findById(long id) {
		return hibernateTemplate.get(Favorite.class, id);
	}

	public void delById(int id) {
		
	}

	public List<Favorite> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Favorite findByRepoId(long repoId) {
		String hql = "from Favorite where repositoryId = ?";
		
		List<Favorite> result = this.hibernateTemplate.find(hql,repoId);
		
		return result != null && result.size() > 0 ? result.get(0) : null;
	}

	public List<NewRepositoryVO> findRepoByCondition(final int pageSize, final int pageNum,final long userId) {
		final String hql = "select repositoryId from Favorite where userId = ? and repositoryId != '' order by createTime desc";
		List<Long> temp = this.hibernateTemplate.executeFind(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				
				query.setFirstResult((pageNum - 1) * pageSize);
				query.setMaxResults(pageSize);
				query.setLong(0, userId);
				return query.list();
			}
			
		});
		
		List<NewRepositoryVO> result = new ArrayList<NewRepositoryVO>();
		
		if (temp != null && temp.size() > 0) {
			for (Long id : temp) {
				if (id != null) {
					NewRepositoryVO nr = new NewRepositoryVO();
					
					Repository r = this.repositoryDAO.findById(id);
					List<Medicinal> ms = this.medicinalDAO.findByRepoId(Integer.MAX_VALUE, 1, r.getId());
					
					HttpSession session = ServletActionContext.getRequest().getSession();
					User u = (User) session.getAttribute("user");
					
					nr.setRepository(r);
					nr.setMedicinals(ms);
					nr.setUser(u);
					
					result.add(nr);
				}
			}
		}
	
		return result;
	}

	public int countRepoByCondition(long userId) {
		String hql = "select count(repositoryId) from Favorite where userId = ? and repositoryId != ''";
		List<Long> result = this.hibernateTemplate.find(hql,userId);
		return result != null && result.size() > 0 ? result.get(0).intValue() : null;
	}

	public List<MedicinalVO> findMedByCondition(final int pageSize, final int pageNum,final long userId) {
		final String hql = "select medicinalId from Favorite where userId = ? and medicinalId != '' order by createTime desc";
		
		List<Long> temp = this.hibernateTemplate.executeFind(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				
				query.setFirstResult((pageNum - 1) * pageSize);
				query.setMaxResults(pageSize);
				query.setLong(0, userId);
				return query.list();
			}
			
		});
		
		List<MedicinalVO> result = new ArrayList<MedicinalVO>();
		
		if (temp != null && temp.size() > 0) {
			for (Long id : temp) {
				if (id != null) {
					MedicinalVO mVO = new MedicinalVO();
					
					Medicinal m = this.medicinalDAO.findById(id);
					
					Repository r = this.repositoryDAO.findById(m.getRepositoryId());
					
					HttpSession session = ServletActionContext.getRequest().getSession();
					User u = (User) session.getAttribute("user");
					
					mVO.setMedicinal(m);
					mVO.setRepository(r);
					mVO.setUser(u);
					
					result.add(mVO);
				}
			}
		}
		
		return result;
	}

	public int countMedByCondition(long userId) {
		String hql = "select count(medicinalId) from Favorite where userId = ? and medicinalId != ''";
		List<Long> result = this.hibernateTemplate.find(hql,userId);
		return result != null && result.size() > 0 ? result.get(0).intValue() : null;
	}
	
	public Favorite find(long repoId,long userId) {
		String hql = "from Favorite where repositoryId = ? and userId = ?";
		List<Favorite> result = this.hibernateTemplate.find(hql,repoId,userId);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}

	public List<Favorite> findByUserId(long userId) {
		String hql = "from Favorite where userId = ?";
		return this.hibernateTemplate.find(hql,userId);
	}
}
