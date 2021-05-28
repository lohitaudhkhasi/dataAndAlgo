package com.ds.assignment.week1;

import java.util.Arrays;

public class Question10 {

	public static void main(String[] args) {
		Question10 q = new Question10();
		int[] arr1 = { 1, 5, 7, 8, 10 };
		int[] arr2 = { 1, 2, 9 };
		q.inplaceMerge(arr1, arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

	public void inplaceMerge(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] > arr2[0]) {
				swap(arr1, arr2, i, 0);
				sort(arr2);
			}
		}
	}

	public void swap(int[] arr1, int[] arr2, int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}

	public void sort(int[] arr) {
		if (arr.length == 1) {
			return;
		}
		for (int i = 0; i + 1 < arr.length; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			} else {
				break;
			}
		}
	}
}
