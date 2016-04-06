package com.sbmage.dao;

import java.util.List;
import java.util.Map;

public interface MongoDao {

	void insert(List<Map<String, String>> log);
}
