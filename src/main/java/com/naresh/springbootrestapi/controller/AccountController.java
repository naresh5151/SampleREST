package com.naresh.springbootrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.naresh.springbootrestapi.dao.AccountDAO;

import com.naresh.springbootrestapi.model.Account;

public class AccountController {
	@Autowired
	AccountDAO AccountDAO;
	
	/* to save an Account*/
	@PostMapping("/Accounts")
	public Account createAccount(@Valid @RequestBody Account emp) {
		return AccountDAO.save(emp);
	}
	
	/*get all Accounts*/
	@GetMapping("/Accounts")
	public List<Account> getAllAccounts(){
		return AccountDAO.findAll();
	}
	
	/*get Account by id*/
	@GetMapping("/Accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value="id") Long empid){
		
		Optional<Account> emp=AccountDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp.get());
		
	}
	
	
	/*update an Account by id*/
	@PutMapping("/Accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value="id") Long empid,@Valid @RequestBody Account empDetails){
		
		Optional<Account> emp=AccountDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		Account acc = emp.get();
		acc.setAccountNumber(empDetails.getAccountNumber());
		acc.setBalance(empDetails.getBalance());
		
		Account updateAccount=AccountDAO.save(acc);
		return ResponseEntity.ok().body(updateAccount);
			
		
	}
	
	/*Delete an Account*/
	@DeleteMapping("/Accounts/{id}")
	public ResponseEntity<Account> deleteAccount(@PathVariable(value="id") Long empid){
		
		Optional<Account> emp=AccountDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		if (emp.isPresent()) {
			Account acc = emp.get();
			AccountDAO.delete(acc);
		}
		
		
		return ResponseEntity.ok().build();
		
		
	}
}
