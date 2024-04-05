package com.bhusal.service;

import java.util.List;

import com.bhusal.dto.CategoryDto;

public interface CategoryService {
	// create 
	public CategoryDto createCategory(CategoryDto catDto);
	
	// find category by id
	public CategoryDto categoryById(int id);
	
	// show all the categories
	public List<CategoryDto> findAllCategory();
	
	// delete a category
	public void deleteCategory(int id);
	 
	// update a category
	public CategoryDto updateCategory(CategoryDto catDto,int id);

}
