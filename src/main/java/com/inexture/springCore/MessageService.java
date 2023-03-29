package com.inexture.springCore;

public class MessageService { 
	
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

}
