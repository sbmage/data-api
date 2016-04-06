package com.sbmage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbmage.model.User;
import com.sbmage.service.UserService;

@Controller
public class MongoController extends BaseController {

	@Autowired
	private UserService userService;

	
	/**
	 * Get Users
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/mongo/users")
	public @ResponseBody List<User> getUsers(HttpServletRequest request) {
		
		Map<String, String> params = getParameterMap(request);
		printParams(request, params);
		
		List<User> list = new ArrayList<User>();

		try {
			list = userService.getUsers();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/**
	 * Insert User
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/mongo/insert")
	public @ResponseBody User insert(HttpServletRequest request, User user) {
		
		Map<String, String> params = getParameterMap(request);		
		printParams(request, params);

		try {
			user = userService.insert(user);
		} catch (Exception e) {
			logger.error(this.getClass().getSimpleName(), e);
		}

		return user;
	}
	
	/**
	 * Update User
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/mongo/update")
	public @ResponseBody User update(HttpServletRequest request, User user) {
		
		Map<String, String> params = getParameterMap(request);		
		printParams(request, params);
		
		try {
			user = userService.updateUser(user);
		} catch (Exception e) {
			logger.error(this.getClass().getSimpleName(), e);
		}

		return user;
	}
	
	/**
	 * Delete User
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/mongo/delete")
	public @ResponseBody User delete(HttpServletRequest request, User user) {
		
		Map<String, String> params = getParameterMap(request);		
		printParams(request, params);
		
		try {
			userService.deleteUser(user);
		} catch (Exception e) {
			logger.error(this.getClass().getSimpleName(), e);
		}

		return user;
	}
	
}
