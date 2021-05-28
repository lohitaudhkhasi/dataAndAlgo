package com.ds.assignment.week2;

public class Question32 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Question32 q = new Question32();
		q.smallestSubArrayK(arr, arr.length, 20);
	}

	public int smallestSubArrayK(int[] arr, int n, int k) {
		int high = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		for (int low = 0; low < n; low++) {
			while (sum <= k && high < n) {
				sum = sum + arr[high];
				high++;
			}
			if (sum > k) {
				minLength = Integer.min(minLength, high - low);
				System.out.println(low + "," + (high - 1));
			}
			sum = sum - arr[low];
		}
		System.out.println(minLength);
		return minLength;
	}
}
