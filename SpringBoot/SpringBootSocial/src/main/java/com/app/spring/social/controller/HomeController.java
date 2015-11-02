package com.app.spring.social.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	 private Facebook facebook;

	    @Inject
	    public HomeController(Facebook facebook) {
	        this.facebook = facebook;
	    }

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView homePage(){
		System.out.println("in home");
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/fb/connect", method=RequestMethod.GET)
    public String helloFacebook(Model model) {
        if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute(facebook.userOperations().getUserProfile());
        List<Post> homeFeed = facebook.feedOperations().getHomeFeed();
        model.addAttribute("feed", homeFeed);

        return "feeds";
    }
	
}
