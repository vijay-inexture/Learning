package com.inexture.springCore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MySpringBean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean{

	private String message;

	public void sendMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setBeanName(String name) {
		System.out.println("--- setBeanName executed ---");
	}

	public void setApplicationContext(ApplicationContext applicationContext)
		throws BeansException {
	    System.out.println("--- setApplicationContext executed ---");
	}
	  
	public void afterPropertiesSet() {
		System.out.println("--- afterPropertiesSet executed ---");
	}
	  
	public void destroy() throws Exception {
		System.out.println("--- destroy executed ---");
	}

	public void initMethod() {
		System.out.println("--- init-method executed ---");
	}
	  
	public void destroyMethod() {
		System.out.println("--- destroy-method executed ---");
	}
	@PostConstruct
	public void postConstruct() {
	    System.out.println("--- @PostConstruct executed ---");
	}
	@PreDestroy
	public void preDestroy() {
		System.out.println("--- @PreDestroy executed ---");
	}

	  

}
