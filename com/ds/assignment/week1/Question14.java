package com.ds.assignment.week1;

import java.util.Arrays;

public class Question14 {

	public static void main(String[] args) {
		Question14 q = new Question14();
		int[] arr = { 9, 8, 7, 6, 5, 4 };
		System.out.println(Arrays.toString(arr));
		q.lowHighSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("----------");
		int[] arr1 = { 9, 6, 8, 3, 7 };
		System.out.println(Arrays.toString(arr1));
		q.lowHighSort(arr1);
		System.out.println(Arrays.toString(arr1));
		System.out.println("----------");
		int[] arr2 = { 6, 9, 2, 5, 1, 4 };
		System.out.println(Arrays.toString(arr2));
		q.lowHighSort(arr2);
		System.out.println(Arrays.toString(arr2));
		System.out.println("----------");
		int[] arr3 = { 41, 23, 99, 81, 6, 12, 82, 45, 77 };
		System.out.println(Arrays.toString(arr3));
		q.lowHighSort(arr3);
		System.out.println(Arrays.toString(arr3));
	}

	public void lowHighSort(int[] arr) {
		for (int i = 0; i < arr.length; i = i + 2) {
			if (arr.length == 1 || i >= arr.length - 1) {
				return;
			}
			if (i + 1 == arr.length - 1) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
				return;
			}
			int maxIndex = -1;
			if (arr[i] > arr[i + 1]) {
				maxIndex = i;
			} else {
				maxIndex = i + 1;
			}
			if (arr[maxIndex] < arr[i + 2]) {
				maxIndex = i + 2;
			}
			if (i + 1 != maxIndex) {
				swap(arr, i + 1, maxIndex);
			}
		}
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
