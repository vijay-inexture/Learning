package com.inexture.springCore;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SingletonApp implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	private PrototypeB prototypeB;

	public PrototypeB getPrototypeB() {
		return applicationContext.getBean(PrototypeB.class);
	}

	public void setPrototypeB(PrototypeB prototypeB) {
		this.prototypeB = prototypeB;
	}

	public SingletonApp(PrototypeB prototypeB) {
		super();
		this.prototypeB = prototypeB;
	}

	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.applicationContext=appContext;
		
	}
	
	

}
