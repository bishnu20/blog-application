package com.bhusal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhusal.dto.CommentDto;
import com.bhusal.service.impl.CommentServiceImpl;

@RestController
public class CommentController {
	
	@Autowired
	CommentServiceImpl comImpl;
	
	@PostMapping("/post/{postId}/user/{userId}/createComment")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@RequestParam int postId
			,@RequestParam int userId){
		CommentDto comment = comImpl.createComment(commentDto, postId, userId);
				return new ResponseEntity<CommentDto>(comment,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getComment/{id}")
	public ResponseEntity<CommentDto> getCommentById(@RequestParam int id){
		CommentDto commentById = comImpl.getCommentById(id);
		return new ResponseEntity<CommentDto>(commentById,HttpStatus.OK);
	}
	
	// get all comments
	@GetMapping("/getComments")
	public ResponseEntity<List<CommentDto>> getComments(){
		List<CommentDto> comments = comImpl.comments();
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteComment(@RequestParam int id){
		comImpl.deleteComment(id);
		return   ResponseEntity.ok(Map.of("message","Comment is successfully deleted."));
	}

}
