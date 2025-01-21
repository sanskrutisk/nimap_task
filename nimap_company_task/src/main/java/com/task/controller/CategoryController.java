package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Category;
import com.task.model.Product;
import com.task.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	
	@PostMapping
	public void saveCategory(@RequestBody Category category) {
		cs.saveCategory(category);
		
	}
	
	@GetMapping
	public List<Category> getAllCategories() {
		
		return cs.getAllCategories();
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategoryById(@PathVariable("id") long id)
	{
		Category c=cs.getCategoryById(id);
		return c;
	}
	
	@PutMapping("/categories/{id}")
	public String updateCategory(@RequestBody Category c,@PathVariable("id") long id) {
		
		cs.updateCategory(c,id);
		return "category updated";
	}
	
	@DeleteMapping("/categories/{id}")
	public String deleteCategoryById(@PathVariable("id") long id) {
		
		cs.deleteCategoryById(id);
		return "category deleted..!";
	}
	
	 @GetMapping("/categories")
     public List<Category> PagingData(@RequestParam("page") long pageNo)
     {
		   List<Category> list=cs.paginDataCategory(pageNo);
		   return list;
     }

}
