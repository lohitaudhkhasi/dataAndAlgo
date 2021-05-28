package com.ds.assignment.week1;

public class Question27 {
	public static void main(String[] args) {
		Question27 q = new Question27();
		int[] arr = { 1, 2, 3, 4 };
		q.dCombR(arr, 0, 3, "", arr.length);
	}

	public void dCombR(int[] arr, int i, int k, String out, int n) {
		if (k > n) {
			return;
		}
		if (k == 0) {
			System.out.println(out);
			return;
		}
		for (int j = i; j < n; j++) {
			dCombR(arr, j, k - 1, out + " " + arr[j], n);
		}
	}
}
