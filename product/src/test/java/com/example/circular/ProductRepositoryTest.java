package com.example.circular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.example.circular.Repo.ProductRepository;
import com.example.circular.Model.Product;


@DataJpaTest
@AutoConfigureMockMvc
public class ProductRepositoryTest 
{

	@Autowired
	private ProductRepository productRepo;
	
	private Product product = new Product();//real object
	
	@BeforeEach
	public void init()
	{
		product.setId(101);
		product.setName("product1");
		product.setCost(200);
	}
	
	@Test
	public void saveProductSuccess() throws Exception
	{
		Product u1=null;
		productRepo.save(product);
		u1= productRepo.findById((long) product.getId()).get();
		System.out.println(u1);
		
		assertEquals(product.getName(), u1.getName());
	}
	
	@Test
	public void saveUserFailure() throws Exception
	{
		Product u1=null;
		if(productRepo.findAll().toString().isEmpty())
		{
			productRepo.save(product);
			u1 = productRepo.findById((long) product.getId()).get();
		}
		
		assertNull(u1);
	}
	
}





