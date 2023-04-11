package com.vijay.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
	
	@RequestMapping("/one")
	public String one() {
		System.out.println("first");
		return "redirect:/two";
	}

	@RequestMapping("/two")
	public RedirectView two() {
		System.out.println("second"); 
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("three");
		return redirectView;
	}
	
	@RequestMapping("/three")
	public String three() {
		System.out.println("third");
		return "hello";
	}
}
