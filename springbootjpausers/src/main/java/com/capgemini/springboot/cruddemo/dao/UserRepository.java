package com.capgemini.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capgemini.springboot.cruddemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// no need to write code
}
