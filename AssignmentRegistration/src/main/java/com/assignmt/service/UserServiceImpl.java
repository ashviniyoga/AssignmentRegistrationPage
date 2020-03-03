package com.assignmt.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignmt.Model.Role;
import com.assignmt.Model.User;
import com.assignmt.Repository.RoleRepository;
import com.assignmt.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private BCryptPasswordEncoder bcryptpassword;
	

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		System.out.println("List all the users");
		/* Write a code to get all the users */ 
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bcryptpassword.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepo.findByRoleName("Admin");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		System.out.println("New User has been saved");
		userRepo.save(user);
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		System.out.println("Searching by username");
		 
		return userRepo.findByUserName(username);
	}
	
	public void delete(User user) {
		System.out.println("Deleting the User");
		userRepo.delete(user);
	}
	

}
