package com.learning.springMvc.model;

public class Address {
	
	private Long id;
	private String streat;
	private String city;
	
	public Address() {
		super();
	}
	
	public Address(Long id, String streat, String city) {
		super();
		this.id = id;
		this.streat = streat;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreat() {
		return streat;
	}

	public void setStreat(String streat) {
		this.streat = streat;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
