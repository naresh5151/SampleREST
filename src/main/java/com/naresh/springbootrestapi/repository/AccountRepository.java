package com.naresh.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.springbootrestapi.model.Account;

public interface  AccountRepository extends JpaRepository<Account, Long>  {

}
