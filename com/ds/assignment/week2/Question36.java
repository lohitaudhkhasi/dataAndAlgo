package com.ds.assignment.week2;

public class Question36 {
	public static void main(String[] args) {
		Question36 q = new Question36();
		int[] arr = { 1, 5, 2, 3, 7, 6, 4, 5, 100 };
		q.maxProfiltStock(arr);
	}

	public void maxProfiltStock(int[] arr) {
		boolean isIncreasing = false;
		int maxInc = 0;
		int minLocal = arr[0];
		int maxDiff = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				if (!isIncreasing) {
					minLocal = Integer.min(minLocal, arr[i]);
				}
				isIncreasing = true;
				maxInc = arr[i];
			} else if (arr[i] < arr[i - 1] && isIncreasing) {
				maxDiff = maxDiff + maxInc - minLocal;
				isIncreasing = false;
			}

		}
		System.out.println(maxDiff);
	}
}
