package com.niit.backend.dao;

import java.util.List;
import com.niit.backend.model.Product;

public interface ProductDAO{

	

	// get all categories

	public List<Product> list();
	// create product

	public boolean save(Product product);

	// update product

	public boolean update(Product product);

	// delete product by id

	public boolean delete(String id);

	// delete product by product

	public boolean delete(Product product);

	// get product by id

	public Product getProductByID(String id);

	// get product by name
	public Product getProductByName(String name);

}
