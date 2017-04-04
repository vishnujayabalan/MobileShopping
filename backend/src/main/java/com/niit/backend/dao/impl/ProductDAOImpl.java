package com.niit.backend.dao.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//CategoryDAOImpl c = new CategoryDAOImpl
	
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	

	public List<Product> list() {
		//select * from product  -SQL Query - mention the table name
		//from Product  -> HQL -mention Domain class name not table name
		
		//convert the hibernate query into db specific language
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	}

	public boolean save(Product product) {
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Product getProductByID(String id) {
		//select * from Product where id ='mobile'
	//  return	(Product)  sessionFactory.getCurrentSession().get(Product.class, id);
	  
	  return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = '"+id + "'").uniqueResult();
		
	}

	public Product getProductByName(String name) {
		  
		  return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = '"+name + "'").list().get(0);
			

	}

}















