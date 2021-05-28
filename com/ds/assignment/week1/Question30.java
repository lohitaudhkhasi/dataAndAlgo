package com.ds.assignment.week1;

public class Question30 {

	public static void main(String[] args) {
		Question30 q = new Question30();
		int[] arr = { -3, 2, -4, 6, 0, -8, 5 };
		System.out.println(q.maxProduct(arr));
	}

	public static int maxProduct(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
		int msf = Integer.MIN_VALUE;
		int max_eh = arr[0];
		int min_eh = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int temp = max_eh;
			max_eh = Integer.max(arr[i], Integer.max(arr[i] * max_eh, arr[i] * min_eh));
			msf = Math.max(max_eh, msf);
			min_eh = Integer.min(arr[i], Integer.min(arr[i] * min_eh, arr[i] * temp));
		}
		return msf;
	}
}
