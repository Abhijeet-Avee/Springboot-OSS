package com.bankapp.model.service.account;

import java.util.List;

import com.bankapp.model.dao.account.Account;
import com.bankapp.model.dao.account.CurrentAccount;
import com.bankapp.model.dao.account.SavingsAccount;
import com.bankapp.model.dto.AccountDto;

public interface AccountService {
	
//	public List<? super Account> getAllAccounts();
//	public Account getAccountDetail(String accountNumber);
//	public Account addAccount(AccountDto accountDetails);
//	public Account updateAccount(String accountNumber, AccountDto accountDetails);
//	public Account deleteAccount(String accountNumber);
	
	public List<SavingsAccount> getAllSavingsAccounts();
	public List<CurrentAccount> getAllCurrentAccounts();
	public SavingsAccount getSavingAccount(String accountNumber);
	public CurrentAccount getCurrentAccount(String accountNumber);
	public SavingsAccount addSavingsAccount(AccountDto accountDto);
	public CurrentAccount addCurrentAccount(AccountDto accountDto);
	public SavingsAccount updateSavingsAccount(String accountNumber, AccountDto accountDto);
	public CurrentAccount updateCurrentAccount(String accountNumber, AccountDto accountDto);
	public SavingsAccount deleteSavingsAccount(String accountNumber);
	public CurrentAccount deleteCurrentAccount(String accountNumber);
	
	
	public void transfer(String fromAccountNum, String toAccountNum, double amount);
	public void deposit(String accountNumber, double amount);
	public void withdraw(String accountNumber, double amount);
}
