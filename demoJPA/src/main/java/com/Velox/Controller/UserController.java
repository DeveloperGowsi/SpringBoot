package com.Velox.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Velox.UserService.UserService;
import com.Velox.Userclass.User;
import com.Velox.Util.ResponseStructure;
@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/saveUsers")
	public ResponseEntity<ResponseStructure<User>> saveUsers(@RequestBody User user)
	{
		return userservice.saveUsers(user);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@GetMapping("/getUserById")
	public ResponseStructure<User> getUserById(@RequestParam int userId)
	{
		return userservice.getUserById(userId);
	}
	
	@PutMapping("/UpdateById")
	public ResponseStructure<User> UpdateById(@RequestBody User user,@RequestParam  int userId) {
		return userservice.UpdateById(user,userId);
	}
	
	@DeleteMapping("/DeleteUserById")
	public User DeleteUserById(@RequestParam int userId)
	{
		return userservice.DeleteUserById(userId);
	}
	
	@GetMapping("findByname")
	public User findByname(@RequestParam String name,@RequestParam int id) {
		return userservice.findByname(name,id);
	}
	
}
