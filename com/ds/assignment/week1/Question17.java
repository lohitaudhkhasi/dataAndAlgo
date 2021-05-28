package com.ds.assignment.week1;

import java.util.HashMap;
import java.util.Map;

public class Question17 {

	public static void main(String[] args) {
		Question17 q = new Question17();
		int[] arr = { 1, 2, 2, 1, 2 };
		System.err.print("Majority:" + q.vote1(arr));
		System.err.print("Majority:" + q.vote(arr));
	}

	public int vote1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxMajority = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
			maxMajority = Math.max(maxMajority, map.get(arr[i]));
		}
		return maxMajority;
	}

	/**
	 * Boyer Moore Voting algo
	 * 
	 * @param arr
	 * @return
	 */
	public int vote(int[] arr) {
		int majority = -1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				majority = arr[i];
				count = 1;
			} else if (majority != arr[i]) {
				count--;
			} else {
				count++;
			}
		}
		return majority;
	}
}
