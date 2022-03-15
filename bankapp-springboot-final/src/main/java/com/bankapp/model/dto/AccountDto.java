package com.bankapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	
	private String accNumber;
	private String accType;
	private Double interestRate = null;
	private Double overdraft = null;
		
}
