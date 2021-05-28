package com.ds.assignment.week1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Question21 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 8, 5, 7 };
		// int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		Question21 q = new Question21();
		System.out.println(q.longestSubSequence(arr, arr.length));

		// q.lis(arr.length, -1, 0);
	}

	public int lis(int[] n, int prev, int curr) {
		// if ( curr == n) {
		return 0; // TODO
	}

	public int longestSubSequence(int[] arr, int n) {
		int[] lis = new int[n];
		// Initialize with 1
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] <= lis[j]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(lis));
		int max = Integer.MIN_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (lis[i] > max) {
				max = lis[i];
				maxIndex = i;
			}
		}
		// printLis(lis, arr, max);
		printLongestRoutes(lis, arr, max);
		return max;
	}

	public void printLis(int[] lis, int lisIndex, int[] arr, int max) {
		if (max == 0) {
			return;
		}
		if (lis[lisIndex] == max) {
			printLis(lis, lisIndex - 1, arr, max - 1);
			System.out.print(arr[lisIndex] + " ");
		} else {
			printLis(lis, lisIndex - 1, arr, max);
		}
	}

	private void printLongestRoutes(int[] lis, int[] arr, int max) {
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		// Find all max index
		for (int i = arr.length - 1; i >= 0; i--) {
			if (lis[i] == max) {
				queue.add(new Pair(arr[i] + "", i, lis[i]));
			}
		}

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			if (pair.lisValue == 1) {
				System.out.println(pair.psf);
			}
			for (int i = pair.lisIndex - 1; i >= 0; i--) {
				if (lis[i] + 1 == pair.lisValue && arr[i] < arr[pair.lisIndex]) {
					queue.add(new Pair(arr[i] + "->" + pair.psf, i, lis[i]));
				}
			}
		}
	}

	class Pair {
		private String psf;
		private int lisIndex;
		private int lisValue;

		public Pair(String psf, int lisIndex, int lisValue) {
			this.psf = psf;
			this.lisIndex = lisIndex;
			this.lisValue = lisValue;
		}

		public String getPsf() {
			return psf;
		}

		public int getLisIndex() {
			return lisIndex;
		}

		public int getLisValue() {
			return lisValue;
		}

	}
}
