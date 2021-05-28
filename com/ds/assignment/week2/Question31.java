package com.ds.assignment.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question31 {
	public static void main(String[] args) {
		Question31 q = new Question31();
		int[] arr = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
		int sum = 15;
		q.subArraySum1(arr, sum);
		q.subArraySum2(arr, arr.length, sum);

	}

	// Sliding Window if sum is positive
	public void subArraySum1(int[] arr, int k) {
		int sum = 0;
		int n = arr.length;
		int high = 0;
		for (int low = 0; low < n; low++) {
			while (sum < k && high < n) {
				sum += arr[high++];
			}
			if (sum == k) {
				System.out.printf("%d-%d ", low, high - 1);
				System.out.println();
			}
			sum -= arr[low];
		}
	}

	// Hashing concept if sum is positive or negative
	public void subArraySum2(int[] arr, int n, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		map.put(0, list);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (map.containsKey(sum - k)) {
				list = map.get(sum - k);
				for (Integer j : list) {
					System.out.printf("%d-%d,", j + 1, i);
				}
			}
			list = new ArrayList<>();
			list.add(i);
			map.putIfAbsent(sum, list);
		}

		// System.out.println(map);
	}
}
