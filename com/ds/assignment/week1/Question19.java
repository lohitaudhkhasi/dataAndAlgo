package com.ds.assignment.week1;

import java.util.Arrays;

public class Question19 {

	public static void main(String[] args) {
		Question19 q = new Question19();
		int[] arr = { 1, 2, 3, 4 };
		q.multiply(arr);
		q.multiply2(arr, arr.length);
	}

	public void multiply(int[] arr) {
		int[] output = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int p = 1;
			if (i > 0) {
				p = arr[i - 1];
			}
			output[i] = arr[i] * p;
		}
		System.out.println(Arrays.toString(output));
		int product = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i > 0) {
				output[i] = output[i - 1] * product;
			} else {
				output[i] = product;
			}
			product = product * arr[i];
		}
		System.out.println(Arrays.toString(output));
	}

	public void multiply2(int[] arr, int n) {
		int[] output = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) {
			if (i - 1 < 0) {
				left[i] = arr[i] * 1;
			} else {
				left[i] = arr[i] * left[i - 1];
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (i + 1 > n - 1) {
				right[i] = 1 * arr[i];
			} else {
				right[i] = right[i + 1] * arr[i];
			}
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		for (int i = 0; i < n; i++) {
			if (i - 1 < 0) {
				output[i] = right[i + 1];
			} else if (i + 1 > n - 1) {
				output[i] = left[i - 1];
			} else {
				output[i] = left[i - 1] * right[i + 1];
			}
		}
		System.out.println(Arrays.toString(output));
	}
}
