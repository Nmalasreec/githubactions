package com.example.circular.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.circular.Model.Product;
import com.example.circular.Repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> productlist = productRepo.findAll();
		return productlist;
}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
}
