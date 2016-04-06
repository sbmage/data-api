package com.sbmage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbmage.dao.UserDao;
import com.sbmage.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public User insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			userDao.deleteUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

}
