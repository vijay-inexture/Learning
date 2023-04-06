package com.inexture.springCore.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public ClassB classBBean() {
		return new ClassB();
	}
	
	@Bean
	public ClassB classB() {
		return new ClassB();
	}
	
//	autowired byContructor
	@Bean
	public ClassA classA() {
		return new ClassA(classB());
	}

}
