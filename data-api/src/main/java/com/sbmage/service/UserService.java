package com.sbmage.service;

import java.util.List;

import com.sbmage.model.User;

public interface UserService {

	User insert(User user);
	
	User getUser(User user);
	
	List<User> getUsers();
	
	boolean deleteUser(User user);
	
	User updateUser(User user);
	
}
