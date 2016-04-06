package com.sbmage.dao;

import java.util.List;

import com.sbmage.model.User;

public interface UserDao {

	User insert(User user);
	
	User getUser(User user);
	
	List<User> getUsers();
	
	void deleteUser(User user);
	
	User updateUser(User user);
	
}