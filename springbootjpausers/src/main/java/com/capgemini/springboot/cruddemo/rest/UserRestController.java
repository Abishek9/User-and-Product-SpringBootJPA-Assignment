package com.capgemini.springboot.cruddemo.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.cruddemo.entity.User;
import com.capgemini.springboot.cruddemo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService theuserService) {
		userService = theuserService;
	}

	// expose "/students" to return list of students
	@GetMapping("/users")
	public List<User> findAllStudents() {

		return userService.findAllUsers();
	}

	// add mapping for GET /students/{studentId}
	@GetMapping("/users/{userId}")
	public User getStudent(@PathVariable int userId) {

		User user = userService.findUserById(userId);

		if (user == null) {
			throw new RuntimeException("User Id not found:" + userId);
		}

		return user;
	}

	// add mapping for POST /students - add new student
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {

		// also just in case they pass an id in JSON .... set id to 0
		// this is to force a save of new item .... instead of update
		user.setId(0);

		userService.save(user);

		return user;
	}

	// add mapping for PUT /students - update student
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {

		userService.save(user);
		return user;
	}

	// add mapping for DELETE /students/{studentId} - delete student
	@DeleteMapping("/users/{userId}")
	public String deleteStudent(@PathVariable int userId) {

		User theUser = userService.findUserById(userId);

		// throw exception if null
		if (theUser == null) {
			throw new RuntimeException("User Id not found:" + userId);
		}
		userService.deleteById(userId);

		return "Deleted User id :" + userId;

	}
}
