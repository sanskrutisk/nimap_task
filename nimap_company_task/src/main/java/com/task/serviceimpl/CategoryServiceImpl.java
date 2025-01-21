package com.task.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.model.Category;
import com.task.model.Product;
import com.task.repository.CategoryRepository;
import com.task.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository cr;

	@Override
	public List<Category> getAllCategories() {
		
		return cr.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		
		cr.save(category);
		
	}

	@Override
	public void updateCategory(Category c, long id) {
		c.setId(id);
		cr.save(c);
		
	}

	@Override
	public void deleteCategoryById(long id) {
		cr.deleteById(id);
		
	}

	@Override
	public Category getCategoryById(long id) {
		
		return cr.findById(id).get();
		
	}

	@Override
	public List<Category> paginData(long pageNo) {

		Pageable p=PageRequest.of((int) pageNo,2);
		
		return cr.findAll(p).getContent();
	}

	@Override
	public List<Category> paginDataCategory(long pageNo) {
		
		Pageable pageable=PageRequest.of((int) pageNo,2);
		
		return cr.findAll(pageable).getContent();
		
	}

}
