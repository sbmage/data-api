package com.sbmage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sbmage.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	private static String COLLECTION_NAME = "game_log";

	@Override
	public User insert(User user) {
		mongoTemplate.insert(user, COLLECTION_NAME);
		return user;
	}

	@Override
	public User getUser(User user) {
		return mongoTemplate.findById(user.getUserId(), User.class, COLLECTION_NAME);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}

	@Override
	public void deleteUser(User user) {
		Query query = new Query(new Criteria("userId").is(user.getUserId()));
		mongoTemplate.remove(query, COLLECTION_NAME);
	}

	@Override
	public User updateUser(User user) {
		Query query = new Query(new Criteria("userId").is(user.getUserId()));
		
		Update update = new Update();
		update.set("userName", user.getUserName());
		update.set("password", user.getPassword());
		update.set("login", user.getLogin());
		update.set("logout", user.getLogout());
		
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
		
		return user;
	}
}
