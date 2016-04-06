package com.sbmage.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sbmage.service.MongoService;

@Component
@EnableScheduling
public class ScheduledTasks {

	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	MongoService mongoService;
	
	@Resource(name="redisTemplate")
	private ListOperations<String, Map<String, String>> listOps;
	
	private final String redisKey = "GameLog";
	
	
	@Scheduled(fixedRate=60000) // 1000 * 60 
	public void redisToMongo() throws Exception {
		logger.info("redisToMongo");
		
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		
		Long size = listOps.size(redisKey);
		for (long i = 0; i < size; i++) {
			Map<String, String> map = listOps.rightPop(redisKey);
			
			list.add(map);
		}
		
		mongoService.insert(list);

	}
}
