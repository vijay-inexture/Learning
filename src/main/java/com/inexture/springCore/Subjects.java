package com.inexture.springCore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Subjects {
	
//	@Autowired
	private Student student;
	private List<String> subjectNames;
	
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public Subjects(Student student) {
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<String> getSubjectNames() {
		return subjectNames;
	}

	public void setSubjectNames(List<String> subjectNames) {
		this.subjectNames = subjectNames;
	}
	
	
	
	public void displaySubjectNames() {
		System.out.println("subjectNames: "+subjectNames);
	}
	
	public void displayStudent() {
		System.out.println("student name: "+student.getName());
	}

}
