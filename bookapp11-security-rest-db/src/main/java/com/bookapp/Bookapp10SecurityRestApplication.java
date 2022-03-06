package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.dao.User;
import com.bookapp.model.service.UserService;

@SpringBootApplication
public class Bookapp10SecurityRestApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Bookapp10SecurityRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		userService.addUser(new User("yash","yash","ROLE_ADMIN"));
//		userService.addUser(new User("abhi","abhi","ROLE_EMP"));
//		userService.addUser(new User("abhijeet","abhijeet","ROLE_MGR"));
	}

}
