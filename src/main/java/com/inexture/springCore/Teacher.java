package com.inexture.springCore;

public class Teacher {
	
	private int id;
	private String name;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void initBean() {
	    System.out.println("Init Bean for : Teacher");
	  }
	   
	 public void destroyBean() {
	    System.out.println("Destroy Bean for : Teacher");
	  }
	
	public void display() {
		System.out.println("name: "+name);
	}

}
