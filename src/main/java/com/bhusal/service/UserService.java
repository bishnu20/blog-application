package com.bhusal.service;

import java.util.List;

import com.bhusal.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto userDto,int id);
	
	UserDto getUserById(int id);
	
	List<UserDto> users();
	
	void deleteUser(int id);

}
