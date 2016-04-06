package com.sbmage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDaoImpl implements MongoDao {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static String COLLECTION_NAME = "game_log";
	
	@Override
	public void insert(List<Map<String, String>> log) {
		
		mongoTemplate.insert(log, COLLECTION_NAME);
	}

}
