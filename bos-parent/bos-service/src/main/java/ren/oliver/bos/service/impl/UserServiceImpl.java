package ren.oliver.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ren.oliver.bos.dao.UserDao;
import ren.oliver.bos.domain.User;
import ren.oliver.bos.service.UserService;
import ren.oliver.bos.utils.MD5Utils;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	public User login(User user) {
		
		String username = user.getUsername();
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(username, password);
	}

	public void editPassword(String id, String password) {

		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password, id);
	}
}
