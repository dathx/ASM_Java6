package com.j6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

}
