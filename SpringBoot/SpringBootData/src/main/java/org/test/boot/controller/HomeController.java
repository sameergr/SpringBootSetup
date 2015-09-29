package org.test.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test")
public class HomeController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) boolean isError){
		if(isError){
			return new ModelAndView("login", "error", "Invalidate Login");
		}
		else{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(){
		return "home";
	}
	
}
