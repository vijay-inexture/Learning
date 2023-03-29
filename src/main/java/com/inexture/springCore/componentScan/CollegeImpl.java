package com.inexture.springCore.componentScan;

import org.springframework.stereotype.Component;

@Component("college")
public class CollegeImpl {
	
	public void test() {
		System.out.println("College test method");
	}

}
