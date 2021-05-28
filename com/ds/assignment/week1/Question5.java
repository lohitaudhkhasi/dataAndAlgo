package com.ds.assignment.week1;

public class Question5 {

	public static void main(String[] args) {
		Question5 q = new Question5();
		int[] arr = { 1, 2, 3, 4, 6, 4, 5 };
		System.out.println(q.findDuplicate2(arr));
	}

	public int findDuplicate(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int xor = 0;
		for (int i : arr) {
			xor = xor ^ i;
		}
		for (int i = 1; i <= arr.length - 1; i++) {
			System.out.println(i);
			xor = xor ^ i;
		}
		return xor;
	}

	public int findDuplicate2(int[] arr) {
		int duplicate = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];

			int index = val - 1;
			if (index < 0) {
				index = index * -1;
			}
			if (arr[index] > 0) {
				arr[index] = -1 * arr[index];
			} else {
				duplicate = arr[i];
				break;
			}
		}
		return duplicate * -1;
	}

}
