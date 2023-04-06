package com.inexture.springCore.InjectConstructorSetterReferBeanMore;

import org.springframework.stereotype.Component;

@Component("collegeBean")
public class College {
	
	private Principal principal;
	
	public College() {
	}

	public College(Principal principal) {
		this.principal = principal;
	}
	
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public void test() {
		principal.principalInfo();
		System.out.println("College test method");
	}

}
