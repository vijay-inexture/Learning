package com.vijay.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome(@RequestParam("name") String name) {
		System.out.println("name: "+name);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("name", name);
		return mv;
	}
}
