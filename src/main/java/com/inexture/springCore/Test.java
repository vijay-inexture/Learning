package com.inexture.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Student student = context.getBean("studentbean", Student.class);  
//		student.displayInfo();
//		
//		Teacher teacher = context.getBean("teacherbean", Teacher.class);
//		teacher.display();
//		
//		Subjects subjects = context.getBean("subjects", Subjects.class);
//		subjects.displaySubjectNames();
//		
//		Subjects referBean = context.getBean("refer-bean", Subjects.class);
//		referBean.displayStudent();
//		
//		Subjects innerBean = context.getBean("inner-bean", Subjects.class);
//		innerBean.displayStudent();
		
//		Subjects byName = context.getBean("byName-bean", Subjects.class);
//		byName.displayStudent();
		
//		Student byType = context.getBean("byType-bean", Student.class);
//		byType.displayInfo();
		
//		Subjects byContructor = context.getBean("byContructor-bean", Subjects.class);
//		byContructor.displayStudent();
		
//		CustomBeanPostProcessor beanPostProcessor = context.getBean("customBeanPostProcessor", CustomBeanPostProcessor.class);
//		Teacher initDestroy = context.getBean("init-destroy", Teacher.class); 
		
//		JdbcExample jdbc = context.getBean("jdbc", JdbcExample.class);
//		jdbc.display();
//
//		MessageService messageService = context.getBean("message-singleton", MessageService.class);
//		messageService.setMessage("message by ms1");
//		messageService.display();
//		
//		MessageService messageService2 = context.getBean("message-singleton", MessageService.class);
//		messageService2.display();
//		
//		MessageService ms = context.getBean("message-prototype", MessageService.class);
//		ms.setMessage("message by ms1");
//		ms.display();
//		
//		MessageService ms2 = context.getBean("message-prototype", MessageService.class);
//		ms2.display();
//		
//		Book beanNameAware = context.getBean("myBook", Book.class);
//		
//		ApplicationContextAwareTest appContext = context.getBean("appContext", ApplicationContextAwareTest.class);
//		ApplicationContext context2 = appContext.getContext();
//		Book book = context2.getBean("myBook", Book.class);
		
//		MessageImpl initDispose = context.getBean("initializing-disposible",MessageImpl.class);
		
//		prototype inside single 
//		lookup method
//		SingletonA singletonA1 = context.getBean("singletonA", SingletonA.class);
//		PrototypeB prototypeB1 = singletonA1.getPrototypeB();
//		SingletonA singletonA2 = context.getBean("singletonA", SingletonA.class);
//		PrototypeB prototypeB2 = singletonA2.getPrototypeB();
//		System.out.println(prototypeB1.equals(prototypeB2));
		
//		prototype inside single 
//		AppContextAware
//		SingletonApp singletonApp = context.getBean("singletonApp", SingletonApp.class);
//		PrototypeB prototypeB3 = singletonApp.getPrototypeB();
//		SingletonApp singletonApp2 = context.getBean("singletonApp", SingletonApp.class);
//		PrototypeB prototypeB4 = singletonApp2.getPrototypeB();
//		System.out.println(prototypeB3.equals(prototypeB4));
		
//		singleton inside prototype
		PrototypeABean prototypeABean1 = context.getBean("prototypeA-Bean", PrototypeABean.class);
		SingletonBBean singletonBBean1 = prototypeABean1.getSingletonABean();
		PrototypeABean prototypeABean2 = context.getBean("prototypeA-Bean", PrototypeABean.class);
		SingletonBBean singletonBBean2 = prototypeABean2.getSingletonABean();
		System.out.println(singletonBBean1.equals(singletonBBean2));
		
		//way 2 - provide proper path
//		String path = "/home/root391/eclipse-workspace/Spring-core-application/src/main/resources/applicationContext.xml";
//		ApplicationContext context = new FileSystemXmlApplicationContext(path);
//		Student student = context.getBean("studentbean", Student.class);  
//		student.displayInfo();
	

	}

}
