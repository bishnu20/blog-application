package com.bhusal.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhusal.dto.CommentDto;
import com.bhusal.entity.Comment;
import com.bhusal.entity.Post;
import com.bhusal.entity.User;
import com.bhusal.exception.ResourceNotFoundEx;
import com.bhusal.repo.CommentRepo;
import com.bhusal.repo.PostRepo;
import com.bhusal.repo.UserRepo;
import com.bhusal.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	// autowire commentRepository
	@Autowired
	private CommentRepo comRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PostRepo postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto,int postId,int userId) {
		 User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundEx("User", "id", userId));
		 Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundEx("Post", "id", postId));
		Comment comment = new Comment();
		comment.setComment(commentDto.getComment());
		comment.setUser(user);
		comment.setPost(post);
		Comment savedComment = comRepo.save(comment);
		CommentDto savedCommentDto = new CommentDto();
		// change commentDto into CommentDto
		BeanUtils.copyProperties(savedComment, savedCommentDto);
		//comRepo.save(comment);		
		return savedCommentDto;
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
