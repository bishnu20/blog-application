package com.bhusal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhusal.dto.UserDto;
import com.bhusal.service.impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// inject UserServiceImpl
	@Autowired
	private UserServiceImpl userSerImpl;
	
	// create user
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto user = userSerImpl.createUser(userDto);
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}
	
	// find user by id
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable int id){
		UserDto userById = userSerImpl.getUserById(id);
		return new ResponseEntity<UserDto>(userById,HttpStatus.OK);
	}
	
	// find all users
	@GetMapping("/showUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userSerImpl.users();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.FOUND);
	}
	
	// delete a user 
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int id){
		   userSerImpl.deleteUser(id);
		   return ResponseEntity.ok(Map.of("message","user is successfully deleted."));
	}
	// This is not working
	// update the user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") int id){
		UserDto updatedUser = userSerImpl.updateUser(userDto,id);
		userSerImpl.createUser(updatedUser);
		
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
		
	}
	

}
