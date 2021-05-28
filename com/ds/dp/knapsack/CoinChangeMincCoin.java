package com.ds.dp.knapsack;

import com.ds.util.Util;

public class CoinChangeMincCoin {

	public static void main(String[] args) {
		int[] coins = { 2, 3, 1 };
		System.out.println(minCoin(coins, coins.length, 5));
	}

	public static int minCoin(int[] coins, int length, int sum) {

		int[][] t = new int[length + 1][sum + 1];
		for (int i = 0; i <= sum; i++) {
			t[0][i] = Integer.MAX_VALUE - 1;
		}
		for (int i = 1; i <= sum; i++) {
			if (i % coins[0] == 0) {
				t[1][i] = i / coins[0];
			} else {
				t[1][i] = Integer.MAX_VALUE - 1;
			}
		}
		for (int i = 0; i <= length; i++) {
			t[i][0] = 0;
		}
		for (int i = 2; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] <= j) {
					t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		Util.display(t);
		return t[length][sum];
	}
}
