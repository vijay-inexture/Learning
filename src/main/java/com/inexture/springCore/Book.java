package com.inexture.springCore;

import org.springframework.beans.factory.BeanNameAware;

public class Book implements BeanNameAware{

	private String bookName;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBookName() {
		return bookName;
	}

	public Book(String bookName) {
		System.out.println("--Inside Constructor--");
		this.bookName = bookName;
	}

	public void setBeanName(String name) {
		System.out.println(name +" bean has been initialized." );	
		
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
