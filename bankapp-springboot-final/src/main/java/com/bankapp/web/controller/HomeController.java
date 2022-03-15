package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path="/home")
	public String home(Principal principal){
		System.out.println(principal.getName());
		return "home";
	}
	@GetMapping(path="/")
	public String welcome() {
		return "redirect:/home";
	}
}
