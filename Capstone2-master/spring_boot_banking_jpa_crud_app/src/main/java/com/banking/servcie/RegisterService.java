package com.banking.servcie;

import java.util.List;

import com.banking.exception.BusinessException;
import com.banking.model.User;

public interface RegisterService {
	
	public User createUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public void enableUser(int uId);
	public void disableUser(int uId);
	public void deleteUserById(int uId);
	public User findByUsername(String username);


}
