package com.example.circular;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.circular.Model.Product;



public class ProductTest {

	@Test
	public void test01()
	{
		Product userObj = Mockito.mock(Product.class); //creating mock object
		when(userObj.getName()).thenReturn(null);
		
		System.out.println("Mocked object result before assignment is:: "+ userObj.getName());
		
		Product newObj = Mockito.mock(Product.class);
		
		when(newObj.getName()).thenReturn("Product1");
		
	}

}
