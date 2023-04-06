package com.inexture.springCore.InjectConstructorSetterReferBeanMore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
//		College college = context.getBean("collegeConfigBean",College.class);
		College college = context.getBean("collegeBeanConstructor",College.class);
//		inject using setter and refer to other bean
//		College college = context.getBean("collegeBeanSetter",College.class);
		college.test();

	}

}
