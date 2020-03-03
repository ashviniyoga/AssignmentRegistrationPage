package com.assignmt.service;

import java.util.List;

import com.assignmt.Model.User;

public interface UserService {
	
	public List<User> getAllUser();
	
	public void save(User user);
	
	public User findByUserName(String username);
	
	public void delete(User user);
	
}
