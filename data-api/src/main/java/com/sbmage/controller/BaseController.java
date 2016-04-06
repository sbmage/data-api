package com.sbmage.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Log Parameters 
	 * 
	 * @param request
	 * @param params
	 */
	protected void printParams(HttpServletRequest request, Map<String, String> params) {
		logger.info("+ uri ::: " + request.getRequestURI());
		logger.info("+ param ::: " + params.toString());
	}
	
	/**
	 * Get Parameters
	 * 
	 * @param request
	 * @return
	 */
	protected Map<String, String> getParameterMap(HttpServletRequest request) {
		
		Enumeration<?> paramNames = request.getParameterNames(); 
		Map<String, String> param = new HashMap<String, String>();
		
		while (paramNames.hasMoreElements()) {
			String key = paramNames.nextElement().toString();
			String value = request.getParameter(key);
			
			param.put(key, value);
		}
		
		return param;
	}

}
