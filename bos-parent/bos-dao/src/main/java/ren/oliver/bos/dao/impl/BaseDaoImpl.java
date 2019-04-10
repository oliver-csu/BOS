package ren.oliver.bos.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ren.oliver.bos.dao.BaseDao;
import ren.oliver.bos.utils.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class<T> entityClass;
	
	public BaseDaoImpl() {
		
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		
		super.setSessionFactory(sessionFactory);
	}

	public void save(T entity) {
		
		this.getHibernateTemplate().save(entity);
	}

	public void delete(T entity) {
		
		this.getHibernateTemplate().delete(entity);
	}

	public void update(T entity) {
		
		this.getHibernateTemplate().update(entity);
	}

	public void saveOrUpdate(T entity) {

		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	public T findById(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	public List<T> findAll() {
		
		String hql = "from " + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	public void executeUpdate(String queryName, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object object : objects) {
			query.setParameter(i++, object);
		}
		query.executeUpdate();
	}

	public void pageQuery(PageBean pageBean) {

		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
        DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();

        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> countList  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        Long count = countList.get(0);
        pageBean.setTotal(count.intValue());
        detachedCriteria.setProjection(null);

        int firstResult = pageSize * (currentPage - 1);
        int maxResult = pageSize;
        List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResult);
        pageBean.setRows(rows);
	}
}
