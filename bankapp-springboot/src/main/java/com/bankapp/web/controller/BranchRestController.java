package com.bankapp.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.dao.branch.Branch;
import com.bankapp.model.service.branch.BranchService;

@RestController
@RequestMapping(path = "api")
public class BranchRestController {
	
	private BranchService branchService;
	
	public BranchRestController(BranchService branchService) {
		this.branchService = branchService;
	}
	
	//Get all branches
	@GetMapping(path="branches", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Branch>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(branchService.findAll());
	}
	
	//Add branch
	@PostMapping(path="branches")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
		return ResponseEntity.status(HttpStatus.CREATED).body(branchService.addBranch(branch));
	}
}
