package com.ds.assignment.week2;

public class Question51 {
	public static void main(String[] args) {
		Question51 q = new Question51();
		int[] arr = { 5, 8, 9, 11, 12, 15 };
		q.a(arr, arr.length);
	}

	public void a(int[] arr, int n) {
		for (int j = 1; j < n; j++) {
			int i = j - 1;
			int k = j + 1;

			while (i >= 0 && k < n) {
				int search = (arr[i] + arr[k]);
				if (search == 2 * arr[j]) {
					System.out.println("(" + arr[i] + "," + arr[j] + "," + arr[k] + ")");
					k++;
					i--;
				} else if (search > 2 * arr[j]) {
					i--;
				} else if (search < 2 * arr[j]) {
					k++;
				}
			}
		}
	}
}
