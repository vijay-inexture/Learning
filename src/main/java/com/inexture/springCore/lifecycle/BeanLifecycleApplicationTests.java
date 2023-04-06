package com.inexture.springCore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifecycleApplicationTests {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfiguration.class);
		MySpringBean mySpringBean = context.getBean("mySpringBean",MySpringBean.class);
		MyBeanPostProcessor myBeanPostProcessor = context.getBean("myBeanPostProcessor",MyBeanPostProcessor.class);
		mySpringBean.sendMessage("Hello");
		
	}

}
