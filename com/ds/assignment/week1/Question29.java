package com.ds.assignment.week1;

public class Question29 {
	public static void main(String args[]) {
		Question29 q = new Question29();
		int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
		q.minSumSize(3, arr);
	}

	public void minSumSize(int k, int[] arr) {
		int min = Integer.MAX_VALUE;
		int endIndex = -1;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			// Init
			sum = sum + arr[i];
			System.out.println("Sum add:" + sum);
			if (i + 1 >= k) {
				if (sum < min) {
					min = sum;
					System.out.println(min);
					endIndex = i;
				}
				// Calc Minus
				sum = sum - arr[i - k + 1];
				System.out.println("Sum minus:" + sum);
			}
		}
		System.out.println(min + "," + (endIndex - k + 1) + ", " + endIndex);
	}
}
