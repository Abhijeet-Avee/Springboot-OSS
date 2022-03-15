package com.bankapp.model.dao.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountDao extends JpaRepository<CurrentAccount, Integer>{
	
	public CurrentAccount findByAccNumber(String accNumber);
	
}
