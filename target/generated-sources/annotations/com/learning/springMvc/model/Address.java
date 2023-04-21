package com.learning.springMvc.model;

import jakarta.validation.constraints.NotNull;

public class Address {
	
	private Long id;
	@NotNull
	private String street;
	@NotNull
	private String city;
	private Long userId;
	
	public Address() {
		super();
	}

	public Address(Long id, String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
