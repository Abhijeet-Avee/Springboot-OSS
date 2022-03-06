package com.bankapp.model.service.user;

import com.bankapp.model.dao.user.User;

public interface UserService {
	public void addUser(User user);
	public User findByUser(String username);
}
