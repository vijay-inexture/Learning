package com.vijay.springMvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionHandlingExController {
	
	@RequestMapping("/exception1")
	public String exceptionHappened() {
		String str = null;
		System.out.println(str.length());
		return "hello";
	}
	
	@RequestMapping("/exception2")
	public String exceptionHappened2() {
		String str = "something";
		int i = Integer.parseInt(str);
		return "hello";
	}
	
//	//handle exception of ExceptionHandlingExController
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler({NullPointerException.class})
//	public String nullException() {
//		return "null_exception";
//	}
//	
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler({NumberFormatException.class})
//	public String numberFormatException() {
//		return "number_exception";
//	}

}
