package com.ds.logicmojo.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {

	public static void main(String args[]) {
		int[] arr = { 2, 4, 3, 6, 4, 1};
		int[] result= new int[arr.length];
		NextGreatestElement nge = new NextGreatestElement();
		nge.nge(arr, result);
		System.out.println(Arrays.toString(result));
	}
	
	public void nge (int[] arr, int[] result) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[arr.length -1]);
		result[arr.length -1] = arr[arr.length - 1];
		for(int i = arr.length -2 ; i >= 0; i--) {
			while(!stack.empty() && arr[i] >= stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
	}
}
