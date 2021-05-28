package com.ds.assignment.week2;

public class Question52 {
	public static void main(String[] args) {
		Question52 q = new Question52();
		int[] arr = { 1, 2, 6, 10, 18, 54 };
		q.printGeo(arr, arr.length);
	}

	public void printGeo(int[] arr, int n) {
		for (int j = 1; j < n; j++) {
			int i = j - 1;
			int k = j + 1;
			while (i >= 0 && k < n) {
				int search = arr[i] * arr[k];
				int sqr = arr[j] * arr[j];
				if (search == sqr) {
					System.out.println("(" + arr[i] + "," + arr[j] + "," + arr[k] + ")");
					i--;
					k++;
				} else if (search < sqr) {
					k++;
				} else if (search > sqr) {
					i--;
				}
			}
		}
	}
}
