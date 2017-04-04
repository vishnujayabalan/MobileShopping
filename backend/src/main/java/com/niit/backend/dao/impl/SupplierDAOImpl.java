package com.niit.backend.dao.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.model.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl  implements SupplierDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//CategoryDAOImpl c = new CategoryDAOImpl
	
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	

	public List<Supplier> list() {
		//select * from supplier  -SQL Query - mention the table name
		//from Supplier  -> HQL -mention Domain class name not table name
		
		//convert the hibernate query into db specific language
	return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
	}

	public boolean save(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Supplier getSupplierByID(String id) {
		//select * from Supplier where id ='mobile'
	//  return	(Supplier)  sessionFactory.getCurrentSession().get(Supplier.class, id);
	  
	  return  (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id = '"+id + "'").uniqueResult();
		
	}

	public Supplier getSupplierByName(String name) {
		  
		  return  (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where name = '"+name + "'").list().get(0);
			

	}

}















