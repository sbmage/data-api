package com.sbmage.service;

import java.util.List;
import java.util.Map;

public interface MongoService {

	void insert(List<Map<String, String>> log);
}
