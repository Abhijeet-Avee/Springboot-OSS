package com.bankapp.model.dao.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_join_table")
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Account {
	
	//1 Customer --> M Account ; cust_id: FK
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "acc_no", nullable = false, unique = true)
	private String accNumber;
	@Column(name = "acc_bal", nullable = false)
	private Double accBalance;
	@Column(name = "acc_type", nullable = false)
	private String accType;

	public Account(String accNumber, Double accBalance, String accType) {
		super();
		this.accNumber = accNumber;
		this.accBalance = accBalance;
		this.accType = accType;
	}
	
	
}
