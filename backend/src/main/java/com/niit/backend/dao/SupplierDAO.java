package com.niit.backend.dao;

import java.util.List;
import com.niit.backend.model.Supplier;

public interface SupplierDAO {

	

	// get all categories

	public List<Supplier> list();
	// create supplier

	public boolean save(Supplier supplier);

	// update supplier

	public boolean update(Supplier supplier);

	// delete supplier by id

	public boolean delete(String id);

	// delete supplier by supplier

	public boolean delete(Supplier supplier);

	// get supplier by id

	public Supplier getSupplierByID(String id);

	// get supplier by name
	public Supplier getSupplierByName(String name);

}
