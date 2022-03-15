package com.bankapp.model.dao.branch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="branch_rest")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String ifsc;
	private String address;
	public Branch() {
		super();
	}
	public Branch(Integer id, String name, String ifsc, String address) {
		super();
		this.id = id;
		this.name = name;
		this.ifsc = ifsc;
		this.address = address;
	}
	public Branch(String name, String ifsc, String address) {
		super();
		this.name = name;
		this.ifsc = ifsc;
		this.address = address;
	}
}
