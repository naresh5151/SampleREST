package com.naresh.springbootrestapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.naresh.springbootrestapi.model.Account;
import com.naresh.springbootrestapi.repository.AccountRepository;

@Repository
public class AccountDAO {

	@Autowired
	AccountRepository AccountRepository;
	
	/*to save an Account*/
	
	public Account save(Account emp) {
		return AccountRepository.save(emp);
	}
	
	
	/* search all Accounts*/
	
	public List<Account> findAll(){
		return AccountRepository.findAll();
	}
	
	
	/*get an Account by id*/
	public Optional<Account> findOne(Long empid) {
		return AccountRepository.findById(empid);
	}
	
	
	/*delete an Account*/
	
	public void delete(Account emp) {
		AccountRepository.delete(emp);
	}
}
