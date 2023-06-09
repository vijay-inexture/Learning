package com.inexture.springCore.InjectConstructorSetterReferBeanMore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {
	
//	@Bean(name="collegeConfigBean")
//	public College collegeBean() {
//		return new College();
//	}
	
	@Bean
	public Principal principalBean() {
		return new Principal();
	}
	
	
	//construction injection
	@Bean
	public College collegeBeanConstructor() {
		return new College(principalBean());
	}
	
	//setter injection 
	//refer to other bean
	@Bean
	public College collegeBeanSetter() {
		College college = new College();
		college.setPrincipal(principalBean());
		return college;
	}

}
