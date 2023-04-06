package com.inexture.springCore.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		    if (bean instanceof MySpringBean) {
		    	System.out.println("--- postProcessBeforeInitialization executed ---");
		    }
		    return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
	      throws BeansException {
		  if (bean instanceof MySpringBean) {
			  	System.out.println("--- postProcessAfterInitialization executed ---");
		  }
		  return bean;
	}

}
