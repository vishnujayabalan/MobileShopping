package com.niit.frontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.model.Product;


@Controller
public class ProductController {
	
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	
	
	//CURD Operations	
	
	
	@PostMapping("/manage_product_create")
	public ModelAndView createCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("categoryid")String categoryid , @RequestParam("supplierid")String supplierid , 
			@RequestParam("price")String price, @RequestParam("quantity")String quantity,@RequestParam("productimages")MultipartFile images)
	{
		
		product.setId(id);
		product.setName(name);
		product.setCategoryid(categoryid);
		product.setSupplierid(supplierid);
		product.setPrice(price);
		product.setQuantity(quantity);
		productDAO.save(product);
		ModelAndView mv = new ModelAndView("redirect:/clickprod");
		String path="D:\\eclipse\\workspace\\Main\\frontend\\src\\main\\resources\\images//";
		product.setPimage(images);
		path=path+String.valueOf(product.getId())+".jpg";
		File f=new File(path);
		
	
		MultipartFile filedet=product.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
			  BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		return mv;
		
	}

	@GetMapping("/manage_product_delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/clickprod");
		
		productDAO.delete(id);
		
		return mv;
		
		
	}
	@RequestMapping("/findProduct")
	public ModelAndView findSupplier(@RequestParam("id") String id, Map<String, Object> map)
	{
		Product product=productDAO.getProductByID(id);
		ModelAndView mv=new ModelAndView("/productdetails","command", new Product() );
		mv.addObject("proFound",product);
		return mv;
	}
	
	@PostMapping("/manage_product_edit")
	public ModelAndView editProduct(@RequestParam("id")String id, 
			@RequestParam("name")String name,  @RequestParam("categoryid")String categoryid , @RequestParam("supplierid")String supplierid , 
			@RequestParam("price")String price, @RequestParam("quantity")String quantity )
	{
		product.setId(id);
		product.setName(name);
		product.setCategoryid(categoryid);
		product.setSupplierid(supplierid);
		product.setPrice(price);
		product.setQuantity(quantity);
		productDAO.update(product);		
		ModelAndView mv = new ModelAndView("redirect:/clickprod");
		return mv;
	}

}