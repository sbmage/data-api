package com.sbmage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(RedisController.class);
	
	@Autowired
	private RedisTemplate<String, String> template;

	@Resource(name="redisTemplate")
	private ListOperations<String, Map<String, String>> listOps;
	
	private final String redisKey = "GameLog";
	
	/**
	 * PUSH
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis/push")
	public @ResponseBody Map<String, String> push(HttpServletRequest request) {
		
		logger.info("--- push ---");
		
		 Map<String, String> params = getParameterMap(request);
		 printParams(request, params);
		Map<String, String> resultMap = new HashMap<String, String>();
		
		long l = listOps.leftPush(redisKey, params);
		
		logger.info("result long::: " + l);
		logger.info("listOps size ::: " + listOps.size(redisKey));
		
		resultMap.put("result", "true");
		
		return resultMap;
	}
	
	
	
	/**
	 * POP
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis/pop")
	public @ResponseBody Map<String, String> pop(HttpServletRequest request) {

		logger.info("--- pop ---");
		
		Map<String, String> map = listOps.rightPop(redisKey);
		
		logger.info("listOps size ::: " + listOps.size(redisKey));
		
		return map;
	}
	
	/**
	 * POPALL
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis/popAll")
	public @ResponseBody List<Map<String, String>> popAll(HttpServletRequest request) {

		logger.info("--- popAll ---");
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		Long size = listOps.size(redisKey);
		for (long i = 0; i < size; i++) {
			Map<String, String> map = listOps.rightPop(redisKey);
			
			list.add(map);
		}

		return list;
	}
	
	/**
	 * All
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/redis/all")
	public @ResponseBody List<Map<String, String>> all(HttpServletRequest request) {

		logger.info("--- all ---");
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		Long size = listOps.size(redisKey);
		for (long i = 0; i < size; i++) {
			Map<String, String> map = listOps.index(redisKey, i);
			
			list.add(map);
		}

		return list;
	}
	
	
}
