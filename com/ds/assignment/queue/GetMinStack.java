package com.ds.assignment.queue;

public class GetMinStack {
	
	int[] arr;
	int N = 10;
	int top = -1;
	int min; 
	
	public GetMinStack() {
		arr = new int[N];
	}
	
	public int getMin() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return min;
	}
	
	public void push(int ele) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		if (isEmpty()) {
			arr[++top] = ele;
			min = ele;
		} else if (ele > min) {
			arr[++top] = ele;
		} else {
			int key = 2 * ele - min;
			arr[++top] = key;
			min = ele;
		}
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		if (arr[top] > min) {
			return arr[top--];
		} else {
			int nextMin = 2 * min - arr[top--];
			int ele = min;
			min = nextMin;
			return ele;
		}
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == N;
	}
	
	public static void main(String[] args) {
		GetMinStack g = new GetMinStack();
		g.push(2);
		System.out.println(g.getMin());
		g.push(3);
		System.out.println(g.getMin());
		g.push(5);
		System.out.println(g.getMin());
		g.push(1);
		System.out.println(g.getMin());
		
		
		System.out.println("popping start");
		System.out.println(g.getMin());
		System.out.println("pop" + g.pop());
		System.out.println(g.getMin());
		System.out.println("pop" + g.pop());
		System.out.println(g.getMin());
		System.out.println("pop" + g.pop());
		System.out.println(g.getMin());
		System.out.println("pop" + g.pop());	
	}
	
}
