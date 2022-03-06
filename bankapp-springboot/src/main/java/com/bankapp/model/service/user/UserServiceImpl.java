package com.bankapp.model.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.user.User;
import com.bankapp.model.dao.user.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
//		this.userDao = userDao;
//		this.passwordEncoder = passwordEncoder;
//	}
	
	@Override
	public void addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User findByUser(String username) {
		return userDao.findByUsername(username);
	}

}
