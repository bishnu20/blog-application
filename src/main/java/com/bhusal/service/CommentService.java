package com.bhusal.service;

import java.util.List;

import com.bhusal.dto.CommentDto;

public interface CommentService {
CommentDto createComment(CommentDto commentDto);
	
CommentDto updateComment(CommentDto commentDto,int id);
	
CommentDto getCommentById(int id);
	
	List<CommentDto> comments();
	
	void deleteComment(int id);

}
