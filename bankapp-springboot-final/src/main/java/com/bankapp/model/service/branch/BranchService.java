package com.bankapp.model.service.branch;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.dao.branch.Branch;

public interface BranchService {
	public Branch addBranch(Branch branch);
	public Optional<Branch> findById(Integer id);
	public List<Branch> findAll();
}
