package com.ds.assignment.week1;

import java.util.HashMap;
import java.util.Map;

public class Question6 {
	int sumReq = 0;

	// Find max length sub-array with sum 8
	public static void main(String[] args) {
		int[] arr = { 1, 3, -3, -2, -1, 2 };
		Question6 q = new Question6();
		System.out.println(q.subArray(arr));
	}

	// Max length of sub-array
	public int subArray(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(sum, -1);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum - sumReq)) {
				int len = i - map.get(sum - sumReq);
				max = Math.max(len, max);
			}
		}
		return max;
	}
}
