package com.task.service;

import java.util.List;

import com.task.model.Category;
import com.task.model.Product;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(long id);

	void updateProduct(Product p);

	

	

	void deleteProductById(Product p, Category c);

	List<Product> paginData(long pageNo);

}
