package com.ds.assignment.week2;

public class Question34 {
	public static void main(String[] args) {
		Question34 q = new Question34();
		int[] arr = { 1, 3, 2, 7, 5, 6, 4, 8 };
		q.subArray(arr, arr.length);
		q.subArray1(arr, arr.length);
	}

	public void subArray(int[] arr, int n) {
		int max = arr[0];
		int fmaxi = -1;
		int lasti = -1;
		for (int i = 1; i < n; i++) {
			if (arr[i] < max) {
				if (fmaxi == -1) {
					fmaxi = i - 1;
				}
				while (arr[i] < max && i < n) {
					i++;
				}
				lasti = i - 1;
			}
			max = arr[i];
		}
		System.out.println(fmaxi + "," + lasti);
	}

	public void subArray1(int[] arr, int n) {
		int max = arr[0];
		int min = arr[n - 1];
		int r = -1;
		int l = -1;
		for (int i = 1; i < n; i++) {
			max = Integer.max(max, arr[i]);
			if (arr[i] < max) {
				r = i;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			min = Integer.min(min, arr[i]);
			if (arr[i] > min) {
				l = i;
			}
		}
		System.out.println(l + ", " + r);
	}
}
