package com.bankapp.model.dao.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "current_account")
public class CurrentAccount extends Account{
	
	private Double overdraft;

	public CurrentAccount(String accNumber, Double accBalance, String accType, Double overdraft) {
		super(accNumber, accBalance, accType);
		this.overdraft = overdraft;
	}	
}
