package com.bhusal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhusal.dto.CategoryDto;
import com.bhusal.entity.Category;
import com.bhusal.exception.ResourceNotFoundEx;
import com.bhusal.repo.CategoryRepo;
import com.bhusal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto catDto) {
		// create an object of Category
		Category catEntity = new Category();
		BeanUtils.copyProperties(catDto, catEntity);
		categoryRepo.save(catEntity);
		return catDto;
	}

	@Override
	public CategoryDto categoryById(int id) {
		Category category = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundEx("Category","id",id));
		CategoryDto catDto = new CategoryDto();
		BeanUtils.copyProperties(category, catDto);
		return catDto;
	}

	@Override
	public List<CategoryDto> findAllCategory() {
		 List<Category> categories = categoryRepo.findAll();
		 // create a list to hold a list of category dto
		 List<CategoryDto> catDtos = new ArrayList<>();
		 for(Category category: categories) {
			 CategoryDto cDto = new CategoryDto();
			 BeanUtils.copyProperties(category, cDto);
			 catDtos.add(cDto);		 
		 }
		 return catDtos;
	}

	@Override
	public void deleteCategory(int id) {
		Category catEntity = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundEx("Category", "id", id));
		categoryRepo.delete(catEntity);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto catDto, int id) {
		// get Category entity corresponding with id
		Category category = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundEx("Category","id", id));
		// update the category
		category.setCategory(catDto.getCategory());
		// save the category
		categoryRepo.save(category);
		// change it into Dto
		BeanUtils.copyProperties(category, catDto);
		return catDto;
	}

}
