package com.bankapp.model.dao.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Integer>{
	
	public SavingsAccount findByAccNumber(String accNumber);
}
