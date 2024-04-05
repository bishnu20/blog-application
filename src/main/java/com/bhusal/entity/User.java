package com.bhusal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int uid;
	@Column(name="user_name")
	@NotEmpty(message="User name must not be empty")
	@Size(min=2,max=20, message="Name must be 2 to 20 chars long.")
	@Pattern(regexp = "^[a-z A-Z]*$",message="name must not contain special characters or numbers.")
	private String uname;
	@NotBlank
	@Column(unique = true)
	private String email;
	@JsonIgnore
	private String password;
	@NotEmpty
	@Size(min=10,max=12,message="Not a valid phone number")
	@Pattern(regexp = "(0|91)?[6-9][0-9]{9}",message="Enter a valid mobile number")
	// here, first number can be 0 or 91, ?-> not mandatory, [6-9]-> can start any number bet 6 to 9, [0-9]-> can contain any number from 0 to 9, {9}-> can repeat 9 times.
	private String phoneNumber;
	private String about;
	
	

}
