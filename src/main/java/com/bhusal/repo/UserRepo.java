package com.bhusal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhusal.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional findByEmailAndPassword(String email,String password);

}
