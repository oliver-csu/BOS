package ren.oliver.bos.service;

import ren.oliver.bos.domain.User;

public interface UserService {

	User login(User user);

    void editPassword(String id, String password);
}