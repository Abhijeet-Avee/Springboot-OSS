package com.bankapp.model.service.branch;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.branch.Branch;
import com.bankapp.model.dao.branch.BranchDao;

@Service
@Transactional
public class BranchServiceImpl implements BranchService{

	private BranchDao branchDao;
	
	@Autowired
	public BranchServiceImpl(BranchDao branchDao) {
		this.branchDao = branchDao;
	}
	
	@Override
	public Branch addBranch(Branch branch) {
		branchDao.save(branch);
		return branch;
	}

	@Override
	public Optional<Branch> findById(Integer id) {
		return branchDao.findById(id);
	}

	@Override
	public List<Branch> findAll() {
		return branchDao.findAll();
	}

}
