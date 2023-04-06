package com.inexture.springCore.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

public class Student {
	
	
	private Book book;

	@Lookup
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Student() {
	}

	public Student(Book book) {
		super();
		this.book = book;
	}

	public void info() {
		System.out.println("student class");
	}
}
