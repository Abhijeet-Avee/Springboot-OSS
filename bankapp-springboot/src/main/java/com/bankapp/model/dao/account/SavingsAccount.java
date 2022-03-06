package com.bankapp.model.dao.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "savings_account")
public class SavingsAccount extends Account{
	
	private Double interestRate;

	public SavingsAccount(String accNumber, Double accBalance,String accType, Double interestRate) {
		super(accNumber, accBalance, accType);
		this.interestRate = interestRate;
	}	
	
}
