package com.niit.backend;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.model.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}
	@Test
	public void createSupplier()
	{
		supplier.setId("01");
		supplier.setName("Vishnu");
		supplier.setAddress("chennai");
		boolean f=supplierDAO.save(supplier);
	}
}