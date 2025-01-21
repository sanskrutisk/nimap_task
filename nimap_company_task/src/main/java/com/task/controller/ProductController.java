package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.task.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private CategoryService cs;
	
	@PostMapping
	public void saveProduct(@RequestBody Product product) {
		 if (product.getCategory() != null && product.getCategory().getId() > 0) {
	            ps.saveProduct(product);
	        } else {
	            throw new IllegalArgumentException("Category must exist and have a valid ID.");
	        }
	}
	
	/*
	 * @GetMapping("/products") public List<Product> getAllProducts() {
	 * 
	 * 
	 * 
	 * }
	 */
	
	@GetMapping("/products/{id}")
	public Product getProductByID(@PathVariable("id") long id) {
		
		Product p=ps.getProductById(id);
	    return p;
	}
	
	@PutMapping("/products/{id}")
	public String updateProduct(@RequestBody Product p) {
		
		Category c =cs.getCategoryById(p.getCategory().getId());
		p.setCategory(c);
		ps.updateProduct(p);
		return "product updated...!";
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		
		Product p = ps.getProductById(id);
		Category c = cs.getCategoryById(p.getCategory().getId());
		ps.deleteProductById(p,c);
		return "product deleted..!";	
	}
	
	      @GetMapping("/products")
       public List<Product> PagingData(@RequestParam("page") long pageNo)
       {
		   List<Product> list=ps.paginData(pageNo);
		   return list;
       }
	
	
	
	
	
	
}
