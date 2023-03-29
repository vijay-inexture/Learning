package com.inexture.springCore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CollectionsConfig.class);
		CollectionsBean collectionsBean = context.getBean("collectionsBean", CollectionsBean.class);
		collectionsBean.displayNameList();
	}

}
