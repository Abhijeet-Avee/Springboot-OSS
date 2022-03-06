package com.bookapp.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "home")
	public String sayHome() {
		return "home";
	}

	@GetMapping(path = "admin")
	public String sayAdmin() {
		return "admin home";
	}

	@GetMapping(path = "mgr")
	public String sayMgr() {
		return "mgr home";
	}

	@GetMapping(path = "emp")
	public String sayEmp() {
		return "emp home";
	}

}