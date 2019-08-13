package com.project.movies;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movies.DAO.UserDao;
import com.project.movies.Validator.UserRegisterValidator;
import com.project.movies.pojos.User;

@Controller
public class RegisterController {
	@Autowired
	UserDao userdao;
	
	@Autowired
	UserRegisterValidator userRegisterValidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userRegisterValidator);
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public String showRegisterForm(@ModelAttribute("user") User user) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String verifyRegister(@Validated @ModelAttribute("user") User user,BindingResult result,
			Model model, HttpSession session) {

		if (result.hasErrors()) {
			model.addAttribute("errormsg", "error");
			return "errorLogin";  //the are validation errors, go to the form view
		}
		
		System.out.println("in register");
		String name= user.getName();
		String username = user.getUsername();
		String password = user.getPassword();
		
		int users = userdao.addUser(name,username, password);	
		 if(users == 0) {
			 model.addAttribute("loginError", "Error registering in");
			 return "register";
		 }
		 session.setAttribute("user", user);
			 return "login";

		
	}
}
