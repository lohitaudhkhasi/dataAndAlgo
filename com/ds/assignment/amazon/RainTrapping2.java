package com.ds.assignment.amazon;

public class RainTrapping2 {
	public static void main(String[] args) {
		RainTrapping2 r = new RainTrapping2();
		int[] arr = { 0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2 };
		System.out.println(r.solve(arr));
	}

	public int solve(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			int leftp = i - 1;
			int rightp = i + 1;
			int leftMax = 0;
			int rightMax = 0;
			while (leftp >= 0) {
				leftMax = Integer.max(leftMax, arr[leftp]);
				leftp--;
			}
			while (rightp < arr.length) {
				rightMax = Integer.max(rightMax, arr[rightp]);
				rightp++;
			}
			int current = Integer.min(leftMax, rightMax) - arr[i];
			System.out.println("current at index " + i + " is " + current);
			if (current > 0) {
				total += current;
			}
		}
		return total;
	}
}
