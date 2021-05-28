package com.ds.assignment.week2;

import java.util.Arrays;

public class Question43 {
	public static void main(String[] args) {
		Question43 q = new Question43();
		int[] arr = { 1, 2, 3, 4, 5 };
		q.reverse(arr, 1, 4);
		System.out.println(Arrays.toString(arr));
	}

	public void reverse(int[] arr, int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
