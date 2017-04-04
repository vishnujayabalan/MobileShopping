package com.niit.frontend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;
@Controller
public class UserController {
@Autowired	
private UserDAO userDAO;
@Autowired
private User user;
 @PostMapping("/create_register")
public ModelAndView createRegister(@RequestParam("userid")String id, 
		@RequestParam("name")String name, @RequestParam("email")String email , @RequestParam("pwd")String password, 
		@RequestParam("cpwd")String confirmpassword)
{
	 
	 System.out.println("register");
	 user.setRole("USER");
	user.setId(id);
	user.setName(name);
	user.setEmail(email);
	user.setPassword(password);
	user.setConfirmpassword(confirmpassword);
	userDAO.saveUser(user);
	
	ModelAndView m=new ModelAndView("redirect:/regis");
	m.addObject("regiser","true");
	m.addObject("msg","Register Successfully");
	return m;
}
 @PostMapping("/validation")
 public ModelAndView valid(@RequestParam("userid") String id,@RequestParam("pwd") String password )
 {
	 String a="ADMIN";
 System.out.println(id);
	if(userDAO.validate(id, password)!=null)
	{
		if(userDAO.getRole(id).equalsIgnoreCase(a))
		{
		ModelAndView m=new ModelAndView("/index");
		m.addObject("thisadmin","true");
		m.addObject("loginsuccess","true");
		return m;
		}else
		{
		ModelAndView m=new ModelAndView("/index");
		m.addObject("loginsuccess","true");
		m.addObject("thisuser","true");
	    m.addObject("msg","Welcome");
	    return m;
		}
	}else
	{
	ModelAndView mv=new ModelAndView("/login");
	mv.addObject("loginfailure","ture");
		mv.addObject("msg","invalid password or id!");		
		return mv;
	}
	
	}
}
