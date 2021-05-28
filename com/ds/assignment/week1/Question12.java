package com.ds.assignment.week1;

public class Question12 {

	public static void main(String[] args) {
		Question12 q = new Question12();
		int[] arr = { 1, 1, 1, 0, 0 };
		System.out.println(q.index(arr));
	}

	public int index(int[] arr) {
		int count = 0;
		int max = Integer.MIN_VALUE;
		int bestIndex = -1;
		int lastIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count = i - lastIndex;
				if (count >= max) {
					bestIndex = i;
					max = count;
				}
				lastIndex = i;
			} else {
				count++;
			}
		}
		System.out.println(max);
		return bestIndex;
	}
}
