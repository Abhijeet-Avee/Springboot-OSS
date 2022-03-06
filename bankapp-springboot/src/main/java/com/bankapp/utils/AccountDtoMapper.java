package com.bankapp.utils;

import com.bankapp.model.dao.account.Account;
import com.bankapp.model.dao.account.CurrentAccount;
import com.bankapp.model.dao.account.SavingsAccount;
import com.bankapp.model.dto.AccountDto;

public class AccountDtoMapper {

	public static SavingsAccount convertToSavingsAccount(AccountDto accountDto) {
		SavingsAccount account = new SavingsAccount();
		account.setAccNumber(accountDto.getAccNumber());
		account.setAccType(accountDto.getAccType());
		account.setAccBalance(0.0);
		account.setInterestRate(accountDto.getInterestRate());
		return account;
	}

	public static CurrentAccount convertToCurrentAccount(AccountDto accountDto) {
		CurrentAccount account = new CurrentAccount();
		account.setAccNumber(accountDto.getAccNumber());
		account.setAccType(accountDto.getAccType());
		account.setAccBalance(0.0);
		account.setOverdraft(accountDto.getOverdraft());
		return account;
	}
}
