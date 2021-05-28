package com.ds.assignment.week2;

import java.util.Arrays;

public class Question40 {

	public static void main(String args[]) {
		Question40 q = new Question40();
		int[] arr = { 3, 5, 6, 9, 8, 7 };
		q.oneSwap(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public void oneSwap(int[] arr, int n) {

		int low = 0;
		int high = n - 1;
		int leftMax = arr[low];
		int rightMin = arr[high];
		// Find first min less than max
		while (low < n) {
			if (arr[low] < leftMax) {
				break;
			} else {
				leftMax = Integer.max(leftMax, arr[low]);
				low++;
			}
		}
		int li = low - 1;
		// find first max less than min from right
		while (high >= 0) {
			if (arr[high] > rightMin) {
				break;
			} else {
				rightMin = Integer.min(rightMin, arr[high]);
				high--;
			}
		}
		int ri = high + 1;
		swap(arr, li, ri);
	}

	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}