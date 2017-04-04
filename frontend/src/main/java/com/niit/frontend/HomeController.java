package com.niit.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController 
{

	@RequestMapping("/")
	public ModelAndView show()
	{
		System.out.println("Inside show()");
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("showPage", "indexPage");
		return mv;
	}
	@RequestMapping("/admin")
	public ModelAndView admin()
	{
		System.out.println("Inside ()");
		ModelAndView mv=new ModelAndView("/Admin");
		return mv;
	}
	@RequestMapping("/clickhome")
	public ModelAndView home()
	{
		
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}
	@RequestMapping("/clicklog")
	public ModelAndView log()
	{
		System.out.println("Inside log ()");
		ModelAndView mv=new ModelAndView("/login");
		return mv;
	}
	@RequestMapping("/regis")
	public ModelAndView register()
	{
		System.out.println("Inside ()");
		ModelAndView mv=new ModelAndView("/Register");
		return mv;
	}
}
