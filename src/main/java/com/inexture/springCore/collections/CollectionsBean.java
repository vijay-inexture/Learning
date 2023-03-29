package com.inexture.springCore.collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CollectionsBean {

	@Autowired
	private List<String> nameList;
	
	public void displayNameList() {
		System.out.println("nameList: "+nameList);
	}
}
