package com.niit.backend;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {
	
	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		category = (Category) context.getBean("category");
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	//TEST CASES
	@Test
	public void updateCategory()
	{
		category.setid("CG02032017");
		category.setName("Men");
		category.setDescription("Men Category");
		boolean flag=categoryDAO.update(category);
	}
  
	
   @Test
   public void deleteCategory()
   {
	   boolean flag=categoryDAO.delete("CG020320");
	   Assert.assertEquals( "deleteCategory" ,true, flag);
	   
   }
   
}	
	