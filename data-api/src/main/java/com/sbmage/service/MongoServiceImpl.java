package com.sbmage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbmage.dao.MongoDao;

@Service
public class MongoServiceImpl implements MongoService {
	
	@Autowired
	MongoDao mongoDao;
	
	@Override
	public void insert(List<Map<String, String>> log) {
		mongoDao.insert(log);
	}

}
