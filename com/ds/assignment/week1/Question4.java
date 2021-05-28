package com.ds.assignment.week1;

import java.util.Arrays;

public class Question4 {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 1, 0, 0 };
		sortBinaryArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * Sort binary array in linear time
	 * 
	 * @param arr
	 */
	public static void sortBinaryArray(int[] arr) {
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[k++] = 0;
			}
		}
		for (int i = k; i < arr.length; i++) {
			arr[i] = 1;
		}
	}

	public static void sortBinaryArray2(int[] arr) {

	}
}
