package com.inexture.springCore.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertyTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		PropertyDemo propertyDemo = context.getBean("propertyDemo", PropertyDemo.class);
		propertyDemo.display();
	}

}
