package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Mycart;

public interface MycartDAO {
	public List<Mycart> list();

	// create mycart

	public boolean save(Mycart mycart);

	// update mycart

	public boolean update(Mycart mycart);

	// delete mycart by id

	public boolean delete(String cartid);

	// delete mycart by mycart

	public boolean delete(Mycart mycart);

	// get mycart by id

	public Mycart getMycartByID(String id);

	// get mycart by name
	public Mycart getMycartByName(String name);

	

}
