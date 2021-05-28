package com.ds.assignment.week1;

import java.util.Arrays;

public class Question9 {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 2, 0, 1 };
		Question9 q = new Question9();
		q.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public void sort(int[] arr, int low, int high) {
		int m = low;
		int l = low;
		int h = high;
		while (m <= h) {
			if (arr[m] == 0) {
				swap(arr, l, m);
				l++;
				m++;
			} else if (arr[m] == 1) {
				m++;
			} else if (arr[m] == 2) {
				swap(arr, m, h);
				h--;
			}
		}
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
