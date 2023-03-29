package com.inexture.springCore.componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CollegeImpl college = context.getBean("college", CollegeImpl.class);
		college.test();
	}

}
