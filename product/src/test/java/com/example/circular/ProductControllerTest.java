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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.circular.Controller.Controller;
import com.example.circular.Service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.circular.Model.Product;
@AutoConfigureMockMvc
@SpringBootTest

public class ProductControllerTest {

	
		@Mock
		private ProductServiceImpl us;
		
		@InjectMocks
		private Controller uc;
		
		@Autowired
		private MockMvc mockmvc;
		
		
		
		@BeforeEach
		public void init()
		{
			MockitoAnnotations.openMocks(this);
			mockmvc = MockMvcBuilders.standaloneSetup(uc).build();
		}
		
	private List<Product> productlist = new ArrayList<>();
		
		@Test
		public void getAllProductSuccess() throws Exception
		{
			Product userObj = new Product();
			
			userObj.setId(102);
			userObj.setName("product2");
			userObj.setCost(300);
			
			productlist.add(userObj);
			when(us.getAllProducts()).thenReturn(productlist);
			
			List<Product> ulist = us.getAllProducts();//redundant
			
			assertEquals(productlist, ulist);// redundant
			assertEquals(1, productlist.size());
			
		mockmvc.perform(MockMvcRequestBuilders.get("/getAll").contentType(MediaType.APPLICATION_JSON))
							.andExpect(MockMvcResultMatchers.status().isOk());
			
		}
		
		
		@Test
		public void getAllProductFailure() throws Exception
		{
		
			productlist.clear();
			Mockito.when(us.getAllProducts()).thenReturn(productlist);//pass null
			
			
			assertEquals(0, productlist.size());
			
		mockmvc.perform(MockMvcRequestBuilders.get("/getAll").contentType(MediaType.APPLICATION_JSON))
							.andExpect(MockMvcResultMatchers.status().isNoContent());
			
		}
		
		
		@Test
		public void addProductSuccess() throws Exception
		{
			Product userObj = new Product();
			userObj.setId(102);
			userObj.setName("product2");
			userObj.setCost(300);
			
			productlist.add(userObj);
			Mockito.when(us.addProduct(any())).thenReturn(userObj);
			
			Product u1 = us.addProduct(userObj);
			
			
			assertEquals(1, productlist.size());
			
		mockmvc.perform(MockMvcRequestBuilders.post("/addProduct").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(userObj)))
							.andExpect(MockMvcResultMatchers.status().isCreated());
			
		}
		
		
		@Test
		public void addProductFailure() throws Exception
		{
			
			when(us.addProduct(any())).thenReturn(null);
			
			Product u1 = us.addProduct(null);
			
			
			assertNull(u1);
			
		mockmvc.perform(MockMvcRequestBuilders.post("/addProduct").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(null)))
							.andExpect(MockMvcResultMatchers.status().isBadRequest());
			
		}

	}

