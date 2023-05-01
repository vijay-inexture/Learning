package com.learning.springMvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({UserNotFoundException.class})
	public ModelAndView handlerUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ModelAndView model = new ModelAndView();
	    model.addObject("errorMessage", ex.getMessage());
	    model.addObject("errorDescription", ex.toString());
	    model.setViewName("error");
	    return model;
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({UserAccessDeniedException.class})
	public ModelAndView handlerUserAccessDeniedException(UserAccessDeniedException ex, WebRequest request) {
		ModelAndView model = new ModelAndView();
	    model.addObject("errorMessage", ex.getMessage());
	    model.addObject("errorDescription", ex.toString());
	    model.setViewName("error");
	    return model;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({UserAlreadyExistException.class})
	public ModelAndView handlerUserAlreadyExistException(UserAlreadyExistException ex, WebRequest request) {
		ModelAndView model = new ModelAndView();
	    model.addObject("errorMessage", ex.getMessage());
	    model.addObject("errorDescription", ex.toString());
	    model.setViewName("error");
	    return model;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public ModelAndView handlerException(Exception ex, WebRequest request) {
		ModelAndView model = new ModelAndView();
	    model.addObject("errorMessage", ex.getMessage());
	    model.addObject("errorDescription", ex.toString());
	    model.setViewName("error");
	    return model;
	}

}
