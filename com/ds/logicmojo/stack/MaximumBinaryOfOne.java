package com.ds.logicmojo.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumBinaryOfOne {

	public static void main(String[] args) {
		int[][] arr = {{ 0, 1, 1, 1, 1, 1},
				{ 1, 1, 1, 1, 1, 1},
				{ 1, 1, 1, 1, 1, 1},
				{ 1, 1, 0, 0, 0, 0}
		};
		MaximumBinaryOfOne m = new MaximumBinaryOfOne();
		int[] sample= {6, 2, 5, 4, 5, 1, 6};
		m.findMaxHistogram(sample);
		System.out.println(m.maxRectangle(arr));
	}
	
	public int maxRectangle(int[][] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if ( i > 0) {
				for (int j = 0; j < arr[0].length; j++) {
					if (arr[i][j] == 1) {
						arr[i][j] = arr[i-1][j] + 1;
					}
				}
			}
			max = Integer.max(findMaxHistogram(arr[i]), max);
		}
		return max;
	}
	
	public int findMaxHistogram(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] lb = new int[arr.length];
		for(int i = 0; i < arr.length ; i++) {
			while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				lb[i] = -1;
			} else {
				lb[i]= stack.peek();
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		int[] rb = new int[arr.length];
		for(int i = arr.length -1 ; i > 0; i--) {
			while(!stack.isEmpty() && arr[i] <= arr[stack.peek() + 1]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				rb[i] = arr.length - 1 ;
			} else {
				rb[i]= stack.peek();
			}
			stack.push(i - 1);
		}
		
		int maxArea = 0;
		System.out.println(Arrays.toString(lb));
		System.out.println(Arrays.toString(rb));
		for (int i = 0; i < arr.length; i++) {
			maxArea = Integer.max(maxArea, (rb[i] - lb[i]) * arr[i]); 
		}
		System.out.println(maxArea);
		return maxArea;
	}
}
