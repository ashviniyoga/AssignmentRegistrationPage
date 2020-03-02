package com.assignmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignmt.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String userName);
	
	User findByUserid(int id);

}
