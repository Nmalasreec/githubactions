package com.example.circular.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.circular.Model.Product;
import com.example.circular.Service.ProductService;


@RestController
public class Controller {
	
	@Autowired
	private ProductService productService;
	
	 @GetMapping("/getAll")
     public List<Product> getProducts() {
        return productService.getAllProducts();

    }
	
	 @PostMapping("/addProduct")
     public String addAccount(@RequestBody Product product)  {
         Product productList=productService.addProduct(product);
         return "Product added successfully";

     }

}
