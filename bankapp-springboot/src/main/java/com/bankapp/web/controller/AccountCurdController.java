package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dto.AccountDto;
import com.bankapp.model.service.account.AccountService;

@Controller
@RequestMapping(path = "accounts")
public class AccountCurdController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountCurdController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@GetMapping(path = "accountops")
	public ModelAndView addAccountGet(ModelAndView mv) {
		mv.setViewName("addaccounts");
		mv.addObject("accountDto", new AccountDto());
		return mv;
	}
	
	@PostMapping(path = "accountops")
	public String transferPost(@ModelAttribute AccountDto accountDto) {
		String accType = accountDto.getAccType();
		if(accType.equals("savings"))
			accountService.addSavingsAccount(accountDto);
		else
			accountService.addCurrentAccount(accountDto);
		return "redirect:success";
	}
	
}
