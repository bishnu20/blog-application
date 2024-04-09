package com.bhusal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhusal.entity.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
