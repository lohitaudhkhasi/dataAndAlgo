package com.ds.sliding.window;

public class MaxSumArray {
	static int size = 3;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, -1, 2, 3, 1 };
		System.out.println(maxSumSubarray(arr));
	}

	public static int maxSumSubarray(int[] arr) {
		if (arr.length < size) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while (j < arr.length) {
			if (j - i + 1 < size) {
				sum = sum + arr[j];
			} else if (j - i + 1 == size) {
				sum = sum + arr[j];
				max = Math.max(max, sum);
				sum = sum - arr[i];
				i++;
			}
			j++;
		}
		return max;
	}
}
