package com.learning.springMvc.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "Please enter Name")
	private String name;
	@NotEmpty(message = "Please enter Email")
	@Email(message = "Please enter valid Email")
	private String email;
	@NotEmpty(message = "Please enter Password")
	private String password;
	private String role;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	public User() {
		super();
	}

	public User(Long id, String name, String email, String password, String role,
			List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
