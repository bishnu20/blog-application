package com.bhusal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhusal.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
