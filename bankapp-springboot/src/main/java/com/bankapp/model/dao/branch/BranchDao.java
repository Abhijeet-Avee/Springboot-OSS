package com.bankapp.model.dao.branch;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<Branch, Integer>{
	public Optional<Branch> findById(Integer id);
}
