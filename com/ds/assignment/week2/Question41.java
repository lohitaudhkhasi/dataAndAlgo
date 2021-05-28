package com.ds.assignment.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question41 {
	public static void main(String[] agrs) {
		Question41 q = new Question41();
		int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
		System.out.println(q.sum3(arr, arr.length, 6, 0));
		q.print_sum3(arr, arr.length, 6);
	}

	public boolean sum3(int[] arr, int index, int sum, int count) {
		if (count == 3 && sum == 0) {
			return true;
		}
		if (index == 0 || count == 3 || sum < 0) {
			return false;
		}
		return sum3(arr, index - 1, sum - arr[index - 1], count + 1) || sum3(arr, index - 1, sum, count);
	}

	public boolean sum3_1(int[] arr, int n, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; i < n; j++) {
				int val = sum - (arr[i] + arr[j]);
				if (map.containsKey(val)) {
					if (map.get(val) != i || map.get(val) != j) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void print_sum3(int[] arr, int n, int sum) {
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int k = sum - arr[i];
			int low = i + 1;
			int high = n - 1;
			while (low < high) {
				if (arr[low] + arr[high] > k) {
					high--;
				} else if (arr[low] + arr[high] < k) {
					low++;
				} else {
					System.out.printf("%d %d %d", arr[i], arr[low], arr[high]);
					System.out.println();
					high--;
					low++;
				}
			}
		}
	}
}
