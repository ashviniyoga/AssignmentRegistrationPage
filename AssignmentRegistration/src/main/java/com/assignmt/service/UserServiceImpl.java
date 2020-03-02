package com.assignmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignmt.Model.User;
import com.assignmt.Repository.RoleRepository;
import com.assignmt.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		System.out.println("List all the users");
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		
		return userRepo.findByUsername(username);
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}
	

}
