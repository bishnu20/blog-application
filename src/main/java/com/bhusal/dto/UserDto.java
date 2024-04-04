package com.bhusal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private int uid;	
	private String uname;	
	private String email;	
	private String password;
	private String phoneNumber;
	private String about;

}
