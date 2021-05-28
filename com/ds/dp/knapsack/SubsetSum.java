package com.ds.dp.knapsack;

public class SubsetSum {
	private static int[] input = { 2, 3, 4 };
	private static int sum = 5;

	public boolean subset(int[] w, int n, int W) {
		boolean t[][] = new boolean[n + 1][W + 1];
		for (int j = 0; j <= W; j++) {
			t[0][j] = false;
		}
		for (int i = 0; i <= n; i++) {
			t[i][0] = true;
		}
		if (n <= 0 || W <= 0) {
			return t[n][W];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i - 1] <= j) {
					if (t[i - 1][j - w[i - 1]]) {
						System.out.println(input[i-1]);
					}
					t[i][j] = t[i - 1][j] || t[i - 1][j - w[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][W];
	}

	public static void main(String args[]) {
		SubsetSum s = new SubsetSum();
		System.out.println(s.subset(input, input.length, sum));
	}
}
