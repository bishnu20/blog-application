package com.bhusal.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhusal.entity.Category;
import com.bhusal.entity.Post;
import com.bhusal.entity.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	Optional<Post> findByImage(String fileName);
}
