package com.bhusal.service;

import java.util.List;

import com.bhusal.dto.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto,int postId,int userId);
	
	CommentDto updateComment(CommentDto commentDto,int id);
	
	CommentDto getCommentById(int id);
	
	List<CommentDto> comments();
	
	void deleteComment(int id);

}
