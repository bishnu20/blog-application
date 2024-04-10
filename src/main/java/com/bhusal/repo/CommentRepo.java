package com.bhusal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhusal.dto.CommentDto;
import com.bhusal.entity.Comment;
import com.bhusal.entity.User;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
	List<CommentDto> findByUser(User user);
	//List<CommentDto> findByPost(int id);

}
