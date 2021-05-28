package com.ds.assignment.week1;

import java.util.HashSet;
import java.util.Set;

public class Question2 {

	public static void main(String[] args) {
		int[] arr = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
		Question2 q2 = new Question2();
		System.out.println(q2.zeroSum(arr));
	}

	// Sliding Window
	public boolean zeroSum(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (set.contains(sum)) {
				return true;
			} else {
				set.add(arr[i]);
			}
		}
		return false;
	}
}
