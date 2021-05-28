package com.ds.dp.knapsack;

// Find the number of ways that these coin can sum to 5
public class CoinChange1 {

	private static int sum = 5;
	private static int[] coins = { 5, 2, 3 };

	public static void main(String args[]) {
		int count = count(coins, coins.length, sum);
		System.out.println(count);
	}

	public static int count(int[] coins, int length, int sum) {
		int[][] t = new int[length + 1][sum + 1];
		for (int i = 0; i <= sum; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= length; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] <= j) {
					t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[length][sum];
	}
}
