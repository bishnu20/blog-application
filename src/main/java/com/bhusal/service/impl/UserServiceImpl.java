package com.bhusal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bhusal.dto.UserDto;
import com.bhusal.entity.User;
import com.bhusal.repo.UserRepo;
import com.bhusal.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	// This method saves the user into database
	@Override
	public UserDto createUser(UserDto user) {
		// create a user entity obj
		User userEntity = new User();
		// convert the data into user entity
		BeanUtils.copyProperties(user, userEntity);
		userRepo.save(userEntity);
		
		return user;
	}
	// This method updates the user into database
	@Override
	public UserDto updateUser(UserDto user, int id) {
		
		return null;
	}
	// return user by its id
	@Override
	public UserDto getUserById(int id) {
		UserDto userDto = new UserDto();
		Optional<User> optional = userRepo.findById(id);
		// copy entity into userDto
		if(optional.isPresent()) {
			BeanUtils.copyProperties(optional.get(), userDto);
		}
		return userDto;
	}
	// return all the users
	@Override
	public List<UserDto> users() {
		List<User> users = userRepo.findAll();
		// create a list to hold all userDtos
		List<UserDto> userDtos = new ArrayList<>();
		// convert all user into user Dto
		for(User user:users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			userDtos.add(userDto);
		}
		return userDtos;
	}
	// deletes a user by its id
	@Override
	public void deleteUser(int id) {
		
		

	}

}
