package com.inexture.springCore.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
//		
//		Student student1 = context.getBean("student", Student.class);
//		Student student2 = context.getBean("student", Student.class);
//		System.out.println(student1.equals(student2));
//		
//		Student stud1 = context.getBean("studentBean", Student.class);
//		Student stud2 = context.getBean("studentBean", Student.class);
//		System.out.println(stud1.equals(stud2));
		
		Student studentBook1 = context.getBean("studentBookBean", Student.class);
		Book book1 = studentBook1.getBook();
		Student studentBook2 = context.getBean("studentBookBean", Student.class);
		Book book2 = studentBook2.getBook();
		System.out.println(book1.equals(book2));
		
		Student studentApp1 = context.getBean("studentBookBean", Student.class);
		Book book_1 = studentApp1.getBook();
		Student studentApp2 = context.getBean("studentBookBean", Student.class);
		Book book_2 = studentApp2.getBook();
		System.out.println(book_1.equals(book_2));
		
	}
	
}
