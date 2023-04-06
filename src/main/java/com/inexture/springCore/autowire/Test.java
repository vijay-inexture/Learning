package com.inexture.springCore.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		ClassA  classA = context.getBean("classA", ClassA.class);
		classA.info();
	}

}
