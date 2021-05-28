package com.ds.assignment.week2;

public class Question44 {

	public static void main(String[] args) {
		Question44 q = new Question44();
		int[] arr = { 1 };
		Pair p = q.solve(arr, arr.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(p.getMax() + "," + p.getMin());
	}

	public Pair solve(int[] arr, int n, int maxp, int minp) {
		if (n == 0) {
			return new Pair(maxp, minp);
		}
		Pair p_left = solve(arr, n - 1, maxp, minp);
		int newMax = Integer.max(p_left.getMax() * arr[n - 1], arr[n - 1]);
		newMax = Integer.max(p_left.getMin() * arr[n - 1], newMax);
		int newMin = Integer.min(p_left.getMax() * arr[n - 1], arr[n - 1]);
		newMin = Integer.min(p_left.getMin() * arr[n - 1], newMin);
		return new Pair(newMax, newMin);
	}

	class Pair {
		int max;
		int min;

		Pair(int max, int min) {
			this.max = max;
			this.min = min;
		}

		public int getMax() {
			return this.max;
		}

		public int getMin() {
			return this.min;
		}
	}
}
