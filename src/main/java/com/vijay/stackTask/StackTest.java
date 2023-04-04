package com.vijay.stackTask;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StackTest {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Stack stack = context.getBean("stackBean", Stack.class);  
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		String userChoice;
		int choice = 0;
		
		//take valid size from user 
		int size;
		boolean invalidInput = false;
		do {
			System.out.println("\nEnter Stack size: ");
			String input = sc.nextLine();
			
			//check user entered size valid or not
			try {
			    size = Integer.parseInt(input);
			    stack.setStack(size);
			    invalidInput = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input!, Please Enter Valid Size.");
				invalidInput = true;
			}
			
		}while(invalidInput);
		
		//iterate until user want to exit
		while(flag) {
			
			System.out.println("\n1. for push");
			System.out.println("2. for pop");
			System.out.println("3. for Display");
			System.out.println("4. for push from specific position");
			System.out.println("5. for pop from specific position");
			System.out.println("6. for exit");
			
			System.out.println("Please enter youe choice: ");
			userChoice = sc.nextLine();
			
			//check user entered choice valid or not
			if(isNumber(userChoice)) {
				choice = Integer.parseInt(userChoice);
				invalidInput = false;
			}else {
				System.out.println("Invalid Input!, Please Enter Valid choice.");
				invalidInput = true;
			}
			
			//if choice is valid then only it will execute
			if(!invalidInput) {
				switch(choice) {
												
					case 1: 
							System.out.println("enter value to push");
							String pushValueStr = sc.nextLine();
							if(isNumber(pushValueStr)) {
								int pushValue = Integer.parseInt(pushValueStr);
								stack.push(pushValue);
							}else {
								System.out.println("Invalid Input!, Please Enter Valid Value.");
							}
							break;
							
					case 2: 
							stack.pop();
							break;
							
					case 3: 
							stack.display();
							break;
							
					case 4: 
							System.out.println("enter value to push");
							String pushValueStr2 = sc.nextLine();
							System.out.println("enter position for push");
							String indexStr = sc.nextLine();
							
							if(isNumber(pushValueStr2) && isNumber(indexStr)) {
								int pushValue2 = Integer.parseInt(pushValueStr2);
								int index = Integer.parseInt(indexStr);
								stack.push(pushValue2, index);;
							}else {
								System.out.println("Invalid Input!, Please Enter Valid Value.");
							}
							break;
							
					case 5: 
							System.out.println("enter position for pop");
							int pos = sc.nextInt();
							stack.pop(pos);
							break;
						
					case 6: 
							flag = false;
							System.out.println("Exit from system");
							break;
					
					default: 
							System.out.println("please enter valid choice");
							break;
					
				}
			}
		}
	}
	
	public static boolean isNumber(String input) {
		try {
		    Integer.parseInt(input);
		    return true;
		} catch (NumberFormatException e) {
		    return false;
		}
	}
	
	
}
