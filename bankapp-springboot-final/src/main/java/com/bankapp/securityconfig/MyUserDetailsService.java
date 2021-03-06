package com.bankapp.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.user.User;
import com.bankapp.model.service.user.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private UserService userService;
	
	@Autowired
	public MyUserDetailsService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("user is not found");
		}

		// need to convert our User into User form UserDetails that spring security understands
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getProfile()));
	}

}
