package com.j6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.AccountDAO;
import com.j6.entity.Account;
import com.j6.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO dao;
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}
}
