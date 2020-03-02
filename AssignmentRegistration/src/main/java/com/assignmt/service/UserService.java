package com.assignmt.service;

import java.util.List;

import com.assignmt.Model.User;

public interface UserService {
	public List<User> getAllUser();
	
	void save(User user);
	
	User findByUsername(String username);
	
	
}
