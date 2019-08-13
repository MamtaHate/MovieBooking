package com.project.movies;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.movies.DAO.UserDao;
import com.project.movies.pojos.Movie;
import com.project.movies.pojos.User;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired
	UserDao userdao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String showLoginForm(@ModelAttribute("user") User user ,
				 BindingResult bindingResult) {
		System.out.println("in method");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@ModelAttribute("movie") Movie movie,
			HttpServletRequest req, Model model, HttpSession session) {
		System.out.println("hsdgdhj");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
			User user = userdao.authenticateLogin(username, password);
			if (user == null) {
				model.addAttribute("loginError", "Error logging in");
				return "login";
			}
			if (username.equals("admin") && password.equals("admin")) {
				return "adminHome";
			}
			session.setAttribute("user", user);
			session.setAttribute("username", user.getUsername());
			return "userHome";
		 	
	}
	

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(HttpSession session){
//            HttpSession httpSession = request.getSession();
            session.invalidate();
            return "redirect:/index.jsp";
        }

	
	}
	