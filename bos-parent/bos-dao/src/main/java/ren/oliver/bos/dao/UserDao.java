package ren.oliver.bos.dao;

import ren.oliver.bos.domain.User;

public interface UserDao extends BaseDao<User> {

	User findUserByUsernameAndPassword(String username, String password);

	User findUserByUsername(String username);
}
