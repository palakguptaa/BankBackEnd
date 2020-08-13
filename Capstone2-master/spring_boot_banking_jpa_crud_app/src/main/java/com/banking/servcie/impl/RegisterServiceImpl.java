package com.banking.servcie.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.UserDAO;
import com.banking.exception.BusinessException;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsAccountService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Override
	public User createUser(User user) {
		user.setEnable(true);
		user.setSavingsAccount(savingsAccountService.createSavingsAccount());
		return dao.save(user);
		
	}

	@Override
	public User updateUser(User user) {
		return dao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public void enableUser(int uId) {
		User enable = dao.findById(uId).get();
		enable.setEnable(true);
//		enable.setDisable(false);
		dao.save(enable);
	}

	@Override
	public void disableUser(int uId) {
		User disable = dao.findById(uId).get();
//		disable.setDisable(true);
		disable.setEnable(false);
		
		dao.save(disable);
		
	}

	@Override
	public void deleteUserById(int uId) {
		dao.deleteById(uId);
	
	}
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
		
	
	}	
	



