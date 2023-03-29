package com.inexture.springCore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageImpl implements InitializingBean, DisposableBean{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	void display() {
		System.out.println("message: "+message);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method after properties are set : " + message);
		
	}

	public void destroy() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
		
	}

}

