package com.niit.backend;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.model.Product;

import junit.framework.Assert;

public class ProductTestCase {
	
	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		product= (Product) context.getBean("product");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	@Test
	public void createSupplier()
	{
		product.setId("01");
		product.setName("furniture");
		product.setCategoryid("c122");
		product.setPrice("3489");
		product.setQuantity("31");
		product.setSupplierid("s123");
		boolean f=productDAO.save(product);
	}
}