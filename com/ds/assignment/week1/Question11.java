package com.ds.assignment.week1;

import java.util.Arrays;

public class Question11 {

	public static void main(String[] args) {
		Question11 q = new Question11();
		int[] arr1 = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
		int[] arr2 = { 1, 8, 9, 10, 15 };
		q.constraintMerge(arr1, arr2);
		System.out.println(Arrays.toString(arr1));
	}

	public void constraintMerge(int[] arr1, int[] arr2) {
		int k = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] > 0) {
				arr1[k++] = arr1[i];
				arr1[i] = 0;
			}
		}
		System.out.println(k);
		merge(arr1, arr2, k - 1);
	}

	public void merge(int[] arr1, int[] arr2, int k) {
		int j = arr2.length - 1;
		for (int index = arr1.length - 1; index >= 0; index--) {
			System.out.println(index);
			if (arr2[j] > arr1[k]) {
				arr1[index] = arr2[j];
				j--;
			} else {
				arr1[index] = arr1[k];
				k--;
			}

		}
	}
}
