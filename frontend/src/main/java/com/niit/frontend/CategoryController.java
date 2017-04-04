package com.niit.frontend;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.model.Category;

@Controller
public class CategoryController {
	
	//Category.jsp  - addCategory, deleteCategory, showCategoryList,updateCategory,editCategory
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	
	//CURD Operations	
	
	
	@PostMapping("/manage_category_create")
	public ModelAndView createCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("description")String description)
	{
		
		category.setid(id);
		category.setName(name);
		category.setDescription(description);
		categoryDAO.save(category);
		ModelAndView mv = new ModelAndView("redirect:/clickcate");
		
		
		
		return mv;
		
	}
	@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/clickcate");
		
		if(categoryDAO.delete(id))
		{
			mv.addObject("message", "Successfully delete the category");
		}
		else
		{
			mv.addObject("message", "Note able delete the category pl contact administrator");
		}
		return mv;
		
		
	}
	@RequestMapping("/findCategory")
	public ModelAndView findCategory(@RequestParam("id") String id, Map<String, Object> map)
	{
		Category category=categoryDAO.getCategoryByID(id);
		ModelAndView mv=new ModelAndView("/categorydetails","command", new Category() );
		mv.addObject("cgFound", category);
		return mv;
	}
	@PostMapping("manage_category_edit")
	public ModelAndView editCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("description")String description ) {
		category.setid(id);
		category.setName(name);
		category.setDescription(description);
		 categoryDAO.update(category);
		 ModelAndView mv=new ModelAndView("redirect:/clickcate");
		return mv;
	}
}