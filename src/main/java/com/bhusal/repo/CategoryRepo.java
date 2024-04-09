package com.bhusal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhusal.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
