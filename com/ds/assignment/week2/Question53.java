package com.ds.assignment.week2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Question53 {
	static int n = 5;

	public static void main(String[] args) {
		Question53 q = new Question53();

		int[] arr = new int[n];
		System.out.println(Arrays.toString(arr));
		q.printKdiff(arr, 1, n, 0);
	}

	public void printKdiff(int[] arr, int i, int n, int index) {
		if (n == 0) {
			System.out.println(Arrays.stream(arr).limit(index).boxed().collect(Collectors.toList()));
			return;
		}
		for (int j = i; j <= n; j++) {
			arr[index] = j;
			printKdiff(arr, j, n - j, index + 1);
		}
	}

}
