package com.inexture.springCore.scope;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StudentApp implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	private Book book;
	
	public StudentApp(Book book) {
		super();
		this.book = book;
	}

	public Book getBook() {
		return applicationContext.getBean(Book.class);
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.applicationContext = appContext;
		
	}

}
