package com.ds.assignment.queue;

public class StackImpl {

	public static void main(String[] args) {
		StackImpl stack = new StackImpl();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	public int[] arr;
	public int top = -1;
	public int size = 10;
	
	public StackImpl () {
		arr = new int[size];
	}
	
	public void push(int ele) {
		if (!isFull()) {
			arr[++top] = ele;
		} else {
			throw new RuntimeException("Stack is full");
		}
	}
	
	public int pop() {
		if (!isEmpty()) {
			int ele = arr[top];
			top--;
			return ele;
		} else {
			throw new RuntimeException("Stack is empty");
		}
	}
	
	public boolean isFull() {
		return top == size;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
}
