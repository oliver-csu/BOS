package ren.oliver.bos.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

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

	public T findById(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	public List<T> findAll() {
		
		String hql = "from " + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

}
