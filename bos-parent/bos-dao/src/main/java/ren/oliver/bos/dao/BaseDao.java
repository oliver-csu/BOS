package ren.oliver.bos.dao;

import ren.oliver.bos.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	void save(T entity);
	
	void delete(T entity);
	
	void update(T entity);

	void saveOrUpdate(T entity);
	
	T findById(Serializable id);
	
	List<T> findAll();

	void executeUpdate(String queryName,Object...objects);

	void pageQuery(PageBean pageBean);
}
