package com.bhusal.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bhusal.dto.PostDto;
import com.bhusal.entity.Category;
import com.bhusal.entity.Post;
import com.bhusal.entity.User;
import com.bhusal.exception.ResourceNotFoundEx;
import com.bhusal.repo.CategoryRepo;
import com.bhusal.repo.PostRepo;
import com.bhusal.repo.UserRepo;
import com.bhusal.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	private PostRepo pRepo;
	private UserRepo uRepo;
	private CategoryRepo cRepo;
	// Constructor injection
	public PostServiceImpl(PostRepo pRepo, UserRepo uRepo, CategoryRepo cRepo) {
		super();
		this.pRepo = pRepo;
		this.uRepo = uRepo;
		this.cRepo = cRepo;
	}

	// creates a post
	@Override
	public PostDto createPost(PostDto pDto,int userId, int catId) {
		User user = uRepo.findById(userId).orElseThrow(()->new ResourceNotFoundEx("User", "id", userId));
		Category category = cRepo.findById(catId).orElseThrow(()->new ResourceNotFoundEx("Category", "id", catId));
		Post post = new Post();
		BeanUtils.copyProperties(pDto, post);
		post.setImage("default.png");
		post.setUser(user);
		post.setCategory(category);	
		//post.setPostedDate(new Date());
		Post savedPost = pRepo.save(post);	
		PostDto postDto = new PostDto();
		BeanUtils.copyProperties(savedPost, postDto);
		return postDto;
	}

	

	@Override
	public PostDto findPostById(int id) {
		Post post = pRepo.findById(id).orElseThrow(()-> new ResourceNotFoundEx("Post", "id", id));
		PostDto postDto = new PostDto();
		BeanUtils.copyProperties(post, postDto);
		return postDto;
		
	}

	@Override
	public List<PostDto> findAllPosts() {
		List<Post>  allPosts = pRepo.findAll();
		// a list that holds all pDtos
		List<PostDto> listOfPostDtos = new ArrayList<>();
		for(Post post:allPosts) {
			PostDto pDto = new PostDto();
			BeanUtils.copyProperties(post, pDto);
			listOfPostDtos.add(pDto);
		}
		return listOfPostDtos;
		
	}

	@Override
	public PostDto updatePost(PostDto pDto, int postId) {
		Post post = pRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundEx("Post", "id", postId));
		post.setTitle(pDto.getTitle());
		post.setContent(pDto.getContent());
		post.setImage(pDto.getImage());
		post.setUpdatedDate(LocalDate.now());
		// save the post
		Post updatedPost = pRepo.save(post);
		PostDto updatedDto = new PostDto();
		BeanUtils.copyProperties(updatedPost, updatedDto);		
		return updatedDto;
	}

	@Override
	public void deletePostById(int id) {
		
		Post post = pRepo.findById(id).orElseThrow(()-> new ResourceNotFoundEx("Post", "id", id));
		/*
		 * uRepo.delete(post.getUser()); cRepo.delete(post.getCategory());
		 */
		pRepo.delete(post);
		
	}

	@Override
	public List<PostDto> getAllPostsByUser(int userId) {
		User user = uRepo.findById(userId).orElseThrow(()->new ResourceNotFoundEx("User", "id", userId));
		List<Post> byUser = pRepo.findByUser(user);
		List<PostDto> listOfPostDtos = new ArrayList<>();
		for(Post post:byUser) {
			PostDto pDto = new PostDto();
			BeanUtils.copyProperties(post, pDto);
			listOfPostDtos.add(pDto);
		}
		return listOfPostDtos;

	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category category = cRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundEx("Category", "id", categoryId));
		List<Post> byCategory = pRepo.findByCategory(category);
		List<PostDto> listOfPostDtos = new ArrayList<>();
		for(Post post:byCategory) {
			PostDto pDto = new PostDto();
			BeanUtils.copyProperties(post, pDto);
			listOfPostDtos.add(pDto);
		}
		return listOfPostDtos;
	
	}


}
