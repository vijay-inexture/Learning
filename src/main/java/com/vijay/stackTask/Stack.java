package com.vijay.stackTask;
import java.util.Scanner;

public class Stack {
	
	private int arr[];
	private int capacity;
	private int top;

	public Stack() {
		super();
	}
	
	public void setStack(int size) {
		this.arr = new int[size];
		this.capacity = size;
		this.top = -1;
	}

	public boolean isFull() {
		if(top == capacity-1) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("Stack overflow, value not inserted");
		}else {
			arr[++top] = value;
			System.out.println("Value push: "+value);
		}
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
		}
		else {
			int popValue = arr[top--];
			System.out.println("value pop:"+popValue);
		}
		
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
		}else {
			for(int i=0;i<=top;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
	
	public void pop(int pos) {
		if(pos>top) {
			System.out.println("Element not Exist at position:"+pos);
		}else {
			int popEl = arr[pos];
			while(pos<top) {
				arr[pos] = arr[pos+1];
				pos++;
			}
			top--;
			System.out.println("value pop:"+popEl);
		}
	}
	
	public void push(int pushValue, int pos) {
		Scanner scanner = new Scanner(System.in);
		//stack is not full, user want to push to next top position
		if(!isFull() && pos==top+1) {
			arr[++top] = pushValue;
			System.out.println("value push:"+pushValue+" at position: "+pos);
			return;
		}
		//user enter position out of range
		else if(pos>top) {
			System.out.println("Invalid position!");
			return;
		}
		//stack is full we need to replace element if user want
		else if(isFull()) {
			System.out.println("You want to replace Element? (y/n)");
			String choice = scanner.nextLine();
			if(choice.equals("y") || choice.equals("Y")) {
				arr[pos] = pushValue;
				System.out.println("value push:"+pushValue+" at position: "+pos);
			}
			else {
				System.out.println("Value not pushed!");
			}
			return;
		}
		//stack is not full and user want to add between some element
		else {
			int loc = top;
			while(pos<=loc) {
				arr[loc+1] = arr[loc];
				loc--;
			}
			arr[++loc] = pushValue;
			++top;
			System.out.println("value push:"+pushValue+" at position: "+pos);
		}
		
	}

}
