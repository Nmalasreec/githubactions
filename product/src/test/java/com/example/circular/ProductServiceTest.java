package com.example.circular;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.circular.Model.Product;
import com.example.circular.Repo.ProductRepository;
import com.example.circular.Service.ProductServiceImpl;
@AutoConfigureMockMvc
@SpringBootTest
public class ProductServiceTest
{
	@Mock
	private ProductRepository userRepo;
	
	@InjectMocks
	private ProductServiceImpl userService;
	
	@Autowired
	private MockMvc mockmvc;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.openMocks(this);
		mockmvc =MockMvcBuilders.standaloneSetup(userService).build();
	}
	
	private List<Product> productlist = new ArrayList<>();
	
	@Test
	public void getAllProductSuccess() throws Exception
	{
		Product userObj = new Product();
		
		userObj.setId(101);
		userObj.setName("product1");
		userObj.setCost(200);
		
		productlist.add(userObj);
		when(userRepo.findAll()).thenReturn(productlist);
		
		List<Product> ulist = userService.getAllProducts();
		
		assertEquals(productlist, ulist);
		
	}
	
	
	@Test
	public void getAllProductFailue() throws Exception
	{
		
		
		
		when(userRepo.findAll()).thenReturn(null);
		
		List<Product> ulist = userService.getAllProducts();
		
		assertNull(ulist);
		
	}
	
	
	@Test
	public void addProductSuccess() throws Exception
	{
		Product userObj = new Product();
		
		userObj.setId(101);
		userObj.setName("product1");
		userObj.setCost(200);
		
		
		productlist.add(userObj);
		when(userRepo.save(any())).thenReturn(userObj);
		
		Product u1 = userService.addProduct(userObj);
		
		assertEquals(userObj, u1);
		
	}
	
	
	@Test
	public void addUserFailure() throws Exception
	{
		Product userObj = new Product();
		
		userObj.setId(101);
		userObj.setName("product1");
		userObj.setCost(200);
		
		productlist.add(userObj);
		when(userRepo.save(any())).thenReturn(null);
		
		Product u1 = userService.addProduct(userObj);
		
		assertNull( u1);
		
	}
	
	
	
	
	

}


