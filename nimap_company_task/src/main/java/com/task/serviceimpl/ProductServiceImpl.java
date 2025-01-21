package com.task.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.model.Category;
import com.task.model.Product;
import com.task.repository.CategoryRepository;
import com.task.repository.ProductRepository;
import com.task.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository pr;
	
	@Autowired
	private CategoryRepository cr;
	
	@Override
	public void saveProduct(Product product) {
		
		pr.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return pr.findAll();
	}

	@Override
	public Product getProductById(long id) {
		
		return pr.findById(id).get();
	}

	@Override
	public void updateProduct(Product p) {
		
		Category c=p.getCategory();
		c.getProducts().add(p);
		cr.save(c);
		
	}

	

	@Override
	public void deleteProductById(Product p, Category c) {
		
		List<Product> plist = c.getProducts();
		 for(int i=0;i<plist.size();i++) {
			 
			Product  rp= plist.get(i);
			if(rp.getId()== p.getId()) {
				plist.remove(i);
				break;
			}	
		 }
		   c.setProducts(plist);
		   pr.deleteById(p.getId());
		 
		}

	@Override
	public List<Product> paginData(long pageNo) {

		Pageable pageable=PageRequest.of((int) pageNo,2);
		
		return pr.findAll(pageable).getContent();
	}

	
		
	

}
