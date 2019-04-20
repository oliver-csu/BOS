package ren.oliver.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ren.oliver.bos.dao.UserDao;
import ren.oliver.bos.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User findUserByUsernameAndPassword(String username, String password) {

		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User findUserByUsername(String username) {

		String hql = "FROM User u WHERE u.username = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
