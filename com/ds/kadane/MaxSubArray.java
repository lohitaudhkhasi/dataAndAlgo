package com.ds.kadane;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, -1, 4, 2, 1, -5, 4 };
		// i < k-1 < j partition from i to k and k+1 to j
		int[] num1 = { 8, -8, 9, -9, 10, -11, 12 };
		int[] num2 = { 10, -3, -4, 7, 6, 5, -4, -1 };
		System.out.println(kadane(nums));
		System.out.println(kadane(num1));
		System.out.println(kadane(num2));
	}

	public static int kadane(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int currentMaxSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int currentMinSum = 0;
		int minSum = Integer.MAX_VALUE;
		int sum = 0;
		for (int num : nums) {
			currentMaxSum = Math.max(num, num + currentMaxSum);
			maxSum = Math.max(currentMaxSum, maxSum);
			currentMinSum = Math.min(num, num + currentMinSum);
			minSum = Math.min(currentMinSum, minSum);
			sum += num;
		}
		if (maxSum < 0) {
			return maxSum;
		}
		return Math.max(maxSum, sum - minSum);
	}
}
