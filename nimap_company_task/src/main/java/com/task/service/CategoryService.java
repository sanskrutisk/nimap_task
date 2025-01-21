package com.task.service;

import java.util.List;

import com.task.model.Category;
import com.task.model.Product;

public interface CategoryService {

	List<Category> getAllCategories();

	void saveCategory(Category category);

	void updateCategory(Category c, long id);

	void deleteCategoryById(long id);

	Category getCategoryById(long id);

	List<Category> paginData(long pageNo);

	List<Category> paginDataCategory(long pageNo);

}
