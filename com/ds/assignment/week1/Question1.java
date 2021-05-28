package com.ds.assignment.week1;

import java.util.HashSet;
import java.util.Set;

// Find pair with given sum in an array (Pair means only two of them)
public class Question1 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Question1 question = new Question1();
		question.givenSum(arr, 8);
	}

	public void givenSum(int[] arr, int sum) {
		Set<Integer> remainSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (remainSet.contains(sum - arr[i])) {
				System.out.println(arr[i] + "," + (sum - arr[i]));
			} else {
				remainSet.add(arr[i]);
			}
		}
	}
}
