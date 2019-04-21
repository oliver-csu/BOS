package ren.oliver.bos.service;

import ren.oliver.bos.domain.User;
import ren.oliver.bos.utils.PageBean;

public interface UserService {

	User login(User user);

    void editPassword(String id, String password);

    void save(User model, String[] roleIds);

    void pageQuery(PageBean pageBean);
}