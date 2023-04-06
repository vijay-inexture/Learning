package com.inexture.springCore.autowire;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ClassA{
	
	//byName
//	@Autowired
//	@Qualifier("classBBean")
	//byType
	@Autowired
	private ClassB classB;

//	public ClassA() {
//	}

	public ClassB getClassB() {
		return classB;
	}

	public void setClassB(ClassB classB) {
		this.classB = classB;
	}

	//byConstructor
//	@Autowired
	public ClassA(ClassB classB) {
		super();
		this.classB = classB;
	}
	
	public void info() {
		System.out.println("hi, this is classA");
	}

}
