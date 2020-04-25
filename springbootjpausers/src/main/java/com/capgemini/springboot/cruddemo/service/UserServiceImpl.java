package com.capgemini.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.cruddemo.dao.UserRepository;
import com.capgemini.springboot.cruddemo.entity.User;



@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository theuserRepository) {
		userRepository = theuserRepository;
	}

	@Override
	public List<User> findAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User findUserById(int id) {

		Optional<User> result = userRepository.findById(id);
		User user1 = null;
		if (result.isPresent()) {
			user1 = result.get();
		} else {
			throw new RuntimeException("Didn't find the User Id :" + id);
		}

		return user1;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

}
