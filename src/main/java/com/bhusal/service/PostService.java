package com.bhusal.service;

import java.util.List;

import com.bhusal.dto.PostDto;
import com.bhusal.entity.Post;

public interface PostService {
	PostDto createPost(PostDto pDto,int userId, int catId);
	PostDto findPostById(int id);
	List<PostDto> findAllPosts();
	PostDto updatePost(PostDto pDto,int id);
	void deletePostById(int postId);
	// get all the post by a user
	List<PostDto> getAllPostsByUser(int userId);
	//get all posts by category
	List<PostDto> getPostByCategory(Integer categoryId);
	

}
