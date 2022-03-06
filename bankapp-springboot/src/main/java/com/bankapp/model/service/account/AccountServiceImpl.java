package com.bankapp.model.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.account.Account;
import com.bankapp.model.dao.account.CurrentAccount;
import com.bankapp.model.dao.account.CurrentAccountDao;
import com.bankapp.model.dao.account.SavingsAccount;
import com.bankapp.model.dao.account.SavingsAccountDao;
import com.bankapp.model.dto.AccountDto;
import com.bankapp.model.exceptions.AccountNotFoundException;
import com.bankapp.utils.AccountDtoMapper;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private CurrentAccountDao currentAccountDao;
	private SavingsAccountDao savingsAccountDao;

	@Autowired
	public AccountServiceImpl(SavingsAccountDao savingsAccountDao, CurrentAccountDao currentAccountDao) {
		this.savingsAccountDao = savingsAccountDao;
		this.currentAccountDao = currentAccountDao;
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		return savingsAccountDao.findAll();
	}

	@Override
	public List<CurrentAccount> getAllCurrentAccounts() {
		return currentAccountDao.findAll();
	}

	@Override
	public SavingsAccount getSavingAccount(String accountNumber) {
		SavingsAccount account = savingsAccountDao.findByAccNumber(accountNumber);
		if(account==null)
			throw new AccountNotFoundException("No account found with account number: "+accountNumber);
		return account;
	}

	@Override
	public CurrentAccount getCurrentAccount(String accountNumber) {
		CurrentAccount account = currentAccountDao.findByAccNumber(accountNumber);
		if(account==null)
			throw new AccountNotFoundException("No account found with account number: "+accountNumber);
		return account;
	}

	@Override
	public SavingsAccount addSavingsAccount(AccountDto accountDto) {
		SavingsAccount account = AccountDtoMapper.convertToSavingsAccount(accountDto);
		return savingsAccountDao.save(account);
	}

	@Override
	public CurrentAccount addCurrentAccount(AccountDto accountDto) {
		CurrentAccount account = AccountDtoMapper.convertToCurrentAccount(accountDto);
		return currentAccountDao.save(account);
	}

	@Override
	public SavingsAccount updateSavingsAccount(String accountNumber, AccountDto accountDto) {
		SavingsAccount account = AccountDtoMapper.convertToSavingsAccount(accountDto);
		SavingsAccount account2 = savingsAccountDao.findByAccNumber(accountNumber);
		account2.setInterestRate(account.getAccBalance());
		savingsAccountDao.save(account2);
		return account2;
	}

	@Override
	public CurrentAccount updateCurrentAccount(String accountNumber, AccountDto accountDto) {
		CurrentAccount account = AccountDtoMapper.convertToCurrentAccount(accountDto);
		CurrentAccount account2 = currentAccountDao.findByAccNumber(accountNumber);
		account2.setOverdraft(account.getOverdraft());
		currentAccountDao.save(account2);
		return account;
	}

	@Override
	public SavingsAccount deleteSavingsAccount(String accountNumber) {
		SavingsAccount account = savingsAccountDao.findByAccNumber(accountNumber);
		savingsAccountDao.delete(account);
		return account;
	}

	@Override
	public CurrentAccount deleteCurrentAccount(String accountNumber) {
		CurrentAccount account = currentAccountDao.findByAccNumber(accountNumber);
		currentAccountDao.delete(account);
		return account;
	}

	@Override
	public void transfer(String fromAccountNum, String toAccountNum, double amount) {
		Account fromAccount, toAccount;
		if((fromAccount = savingsAccountDao.findByAccNumber(fromAccountNum))!=null) {
			fromAccount.setAccBalance(fromAccount.getAccBalance()-amount);
		}else if((fromAccount = currentAccountDao.findByAccNumber(fromAccountNum))!=null) {
			fromAccount.setAccBalance(fromAccount.getAccBalance()-amount);
		}
		if((toAccount = savingsAccountDao.findByAccNumber(toAccountNum))!=null) {
			toAccount.setAccBalance(toAccount.getAccBalance()+amount);
		}else if((toAccount = currentAccountDao.findByAccNumber(toAccountNum))!=null) {
			toAccount.setAccBalance(toAccount.getAccBalance()+amount);
		}
	}

	@Override
	public void deposit(String accountNumber, double amount) {
		Account account;
		if((account = savingsAccountDao.findByAccNumber(accountNumber))!=null) {
			account.setAccBalance(account.getAccBalance()+amount);
		}
		else if((account = currentAccountDao.findByAccNumber(accountNumber))!=null) {
			account.setAccBalance(account.getAccBalance()+amount);
		}
		else throw  new AccountNotFoundException("No account found with account number: "+accountNumber);
	}

	@Override
	public void withdraw(String accountNumber, double amount) {
		Account account;
		if((account = savingsAccountDao.findByAccNumber(accountNumber))!=null) {
			account.setAccBalance(account.getAccBalance()-amount);
		}
		else if((account = currentAccountDao.findByAccNumber(accountNumber))!=null) {
			account.setAccBalance(account.getAccBalance()-amount);
		}
		else throw  new AccountNotFoundException("No account found with account number: "+accountNumber);
	}



}