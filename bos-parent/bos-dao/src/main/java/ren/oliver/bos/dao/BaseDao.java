package ren.oliver.bos.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	void save(T entity);
	
	void delete(T entity);
	
	void update(T entity);
	
	T findById(Serializable id);
	
	public List<T> findAll();
	
}
