package com.ds.assignment.week2;

public class Question37 {
	public static void main(String[] args) {
		Question37 q = new Question37();
		// int[] arr = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };
		// int[] arr = { 3, 0, 3, 3, 0, 3 };
		int[] arr = { 0, 3, 0 };
		q.maxTrap(arr);
	}

	public void maxTrap(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];
		int water = 0;
		while (left < right) {
			if (arr[left] <= arr[right]) {
				left++;
				leftMax = Integer.max(leftMax, arr[left]);
				water += (leftMax - arr[left]);
			} else {
				right--;
				rightMax = Integer.max(rightMax, arr[right]);
				water += (rightMax - arr[right]);
			}
		}
		System.out.println(water);
	}
}
