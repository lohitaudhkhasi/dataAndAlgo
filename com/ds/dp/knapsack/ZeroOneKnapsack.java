package com.ds.dp.knapsack;

public class ZeroOneKnapsack {

	private static int capacity = 4;
	private static int[] weight = { 1, 2, 3, 4 };
	private static int[] value = { 100, 2, 3, 4 };
	private static int NB_ITEMS = 4;
	private static int[][] t = new int[NB_ITEMS + 1][capacity + 1];

	public static void main(String[] args) {
		for (int i = 0; i <= NB_ITEMS; i++) {
			for (int j = 0; j <= capacity; j++) {
				t[i][j] = -1;
			}
		}
		ZeroOneKnapsack ks = new ZeroOneKnapsack();
		System.out.println(ks.optimalProfit(weight, value, NB_ITEMS, capacity));
		System.out.println(ks.optimalProfit2(weight, value, NB_ITEMS, capacity));
	}

	public int optimalProfit(int[] weight, int value[], int n, int capacity) {
		if (n == 0 || capacity == 0) {
			return 0;
		}
		if (t[n][capacity] != -1) {
			return t[n][capacity];
		}
		int index = n - 1;
		if (weight[n - 1] <= capacity) {
			int opw = optimalProfit(weight, value, n - 1, capacity - weight[n - 1]);
			System.out.println("Optimal weight of " + index + " : " + opw + ", value:" + value[n - 1]);
			int option1 = value[n - 1] + opw;
			int option2 = optimalProfit(weight, value, n - 1, capacity);
			System.out.println("Option1:" + option1 + ", option2:" + option2);
			t[n][capacity] = Math.max(option1, option2);
			return t[n][capacity];
		} else {
			return t[n][capacity] = optimalProfit(weight, value, n - 1, capacity);
		}
	}

	public int optimalProfit2(int[] w, int value[], int n, int W) {
		if (n <= 0 || W <= 0) {
			return 0;
		}
		int[][] t = new int[n + 1][W + 1];
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j <= n; j++) {
				t[0][j] = 0;
				t[i][0] = 0;
			}
		}
		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= n; j++) {
				if (w[i - 1] <= j) {
					// System.out.println("i-1:" + (i - 1) + ",j=" + j + ",x:" + (j - w[i - 1]));
					t[i][j] = Math.max(t[i - 1][j], value[i - 1] + t[i - 1][j - w[i - 1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[NB_ITEMS][capacity];
	}
}
