package com.capgemini.springboot.cruddemo.service;

import java.util.List;



import com.capgemini.springboot.cruddemo.entity.User;

public interface UserService {

	public List<User> findAllUsers();

	public User findUserById(int id);

	public void save(User user);

	public void deleteById(int id);
}
