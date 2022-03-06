package com.bookapp.model.service;

import com.bookapp.model.dao.User;

public interface UserService {
	public void addUser(User user);
	public User findByUser(String username);
}
