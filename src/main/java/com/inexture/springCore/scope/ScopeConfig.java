package com.inexture.springCore.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {
	
	@Bean
	@Scope("singleton")
	public Student student() {
		return new Student();
	}
	
	@Bean
	@Scope("prototype")
	public Student studentBean() {
		return new Student();
	}
	
	@Bean
	@Scope("prototype")
	public Book book() {
		return new Book();
	}
	
//	@Bean
//	@Scope("singleton")
//	public Student studentBookBean() {
//		return new Student(book());
//		
//	}
	@Bean
	@Scope("singleton")
	public Student studentBookBean() {
		Student student = new Student();
		student.setBook(book());
		return student;
		
	}
	
	@Bean
	@Scope("singleton")
	public Student StudentApp() {
		return new Student(book());
		
	}

}
