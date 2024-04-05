package com.bhusal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhusal.dto.CategoryDto;
import com.bhusal.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
	// autowire CategoryServiceImpl
	
	@Autowired
	private CategoryServiceImpl catimpl;
	
	// save category
	@PostMapping("/saveCategory")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto catDto){
		CategoryDto category = catimpl.createCategory(catDto);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);		
	}
	
	// find by id
	@GetMapping("/{cateId}")
	public ResponseEntity<?> getCategoryById(@PathVariable("cateId") int id){
		CategoryDto categoryById = catimpl.categoryById(id);
		return new ResponseEntity<>(categoryById,HttpStatus.FOUND);
	}
	
	// delete by id
		@DeleteMapping("/{cateId}")
		public ResponseEntity<?> deleteCategoryById(@PathVariable("cateId") int id){
			catimpl.deleteCategory(id);
			return  ResponseEntity.ok("deleted");
		}
		
		// get all category
		@GetMapping("/getAllCategories")
		public ResponseEntity<List<CategoryDto>> findAllCategories(){
			List<CategoryDto> allCategory = catimpl.findAllCategory();
			return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
		}
		
		// update category
		@PutMapping("/{cateId}")
		public ResponseEntity<?> updateCategory(@RequestBody CategoryDto catDto,@PathVariable("cateId") int id){
			CategoryDto updateCategory = catimpl.updateCategory(catDto, id);
			return new ResponseEntity<>(updateCategory,HttpStatus.ACCEPTED);
			
		}

}
