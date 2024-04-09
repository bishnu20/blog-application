package com.bhusal.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

import com.bhusal.dto.CommentDto;
import com.bhusal.entity.Comment;
import com.bhusal.exception.ResourceNotFoundEx;
import com.bhusal.repo.CommentRepo;
import com.bhusal.service.CommentService;

public class CommentServiceImpl implements CommentService {
	
	// autowire commentRepository
	private CommentRepo comRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto) {
		Comment comment = new Comment();
		// change commentDto into CommentDto
		BeanUtils.copyProperties(commentDto, comment);
		comRepo.save(comment);		
		return commentDto;
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, int id) {
		// create an instance of Comment
		Comment comment = new Comment();
		comment.setComment(commentDto.getComment());
		Comment updatedComment = comRepo.save(comment);
		CommentDto updatedDto = new CommentDto();		
		// change into dto
		BeanUtils.copyProperties(updatedComment, updatedDto);
		
		return updatedDto;
	}

	@Override
	public CommentDto getCommentById(int id) {
		Comment byId = comRepo.findById(id).orElseThrow(()-> new ResourceNotFoundEx("category", "id", id));
		CommentDto cDto = new CommentDto();
		BeanUtils.copyProperties(byId, cDto);	
		return cDto;
	}

	@Override
	public List<CommentDto> comments() {
		List<Comment> allComments = comRepo.findAll();
		// convert all comments into a Dto 
		// create a list of CommentDto
		List<CommentDto> commentDtos = new ArrayList<>();
		for(Comment com: allComments) {
			CommentDto commentDto = new CommentDto();
			BeanUtils.copyProperties(com, commentDto);
			commentDtos.add(commentDto);
			
		}	
		
		return commentDtos;
	}

	@Override
	public void deleteComment(int id) {
		Comment comment = comRepo.findById(id).orElseThrow(()-> new ResourceNotFoundEx("comment", "id", id));
		comRepo.delete(comment);	

	}

}
