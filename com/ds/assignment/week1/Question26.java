package com.ds.assignment.week1;

import java.util.Arrays;

public class Question26 {
	public static void main(String[] args) {
		Question26 q = new Question26();
		int[] arr = { 2, 3, 1, 1 };
		Arrays.sort(arr);
		q.printDistinctCombination(arr, 0, 3, arr.length, "");
	}

	public void printDistinctCombination(int[] arr, int i, int k, int n, String soFar) {
		if (k > n) {
			return;
		}
		if (k == 0) {
			System.out.println(soFar);
			return;
		}
		for (int j = i; j < n; j++) {
			printDistinctCombination(arr, j + 1, k - 1, n, soFar + " " + arr[j]);

			while (j + 1 < n && arr[j] == arr[j + 1]) {
				j++;
			}
		}
	}
}
