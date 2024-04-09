package com.bhusal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhusal.dto.PostDto;
import com.bhusal.service.impl.PostServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {
	
	// inject PostServiceImpl
	@Autowired
	private PostServiceImpl postSerImpl;
	
	// create user
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(
			@Valid @RequestBody PostDto postDto,
			@PathVariable int userId,@PathVariable int categoryId){
		PostDto post = postSerImpl.createPost(postDto,userId,categoryId);
		return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
	}
	
	// find user by id
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPost(@PathVariable int id){
		PostDto postById = postSerImpl.findPostById(id);
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
	}
	
	// find all users
	@GetMapping("/showPosts")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> posts = postSerImpl.findAllPosts();
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.FOUND);
	}
	
	// find by category
	@GetMapping("/findPostsByCategory/{categoryId}")
	public ResponseEntity<?> findByCategory(@PathVariable int categoryId){
		List<PostDto> postByCategory = postSerImpl.getPostByCategory(categoryId);
		return new ResponseEntity<>(postByCategory,HttpStatus.OK);
	}
	
	@GetMapping("/findByUser/{userId}")
	public ResponseEntity<?> findByUser(@PathVariable int userId){
		List<PostDto> postByUser = postSerImpl.getAllPostsByUser(userId);
		return new ResponseEntity<>(postByUser,HttpStatus.OK);
	}
	
	// delete a user 
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable("postId") int id){
		postSerImpl.deletePostById(id);
		   return ResponseEntity.ok(Map.of("message","post is successfully deleted."));
	}
	// This is not working
	// update the user
	/*
	 * @PutMapping("/{postId}") public ResponseEntity<PostDto>
	 * updatePost(@Valid @RequestBody PostDto postDto, @PathVariable("postId") int
	 * id){ PostDto updatedPost = postSerImpl.updatePost(postDto,id);
	 * postSerImpl.createPost(updatedPost); return new
	 * ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
	 * 
	 * }
	 */

}
