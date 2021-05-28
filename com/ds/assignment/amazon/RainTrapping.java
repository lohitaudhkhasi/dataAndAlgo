package com.ds.assignment.amazon;

public class RainTrapping {
	public static void main(String[] args) {
		int[] arr = { 9, 4, 8, 1, 2, 3 };
		RainTrapping r = new RainTrapping();
		System.out.println(r.solve(arr));
		System.out.println(r.solve1(arr));
	}

	public int solve(int[] arr) {
		int maxIndex = 0;
		int maxHeight = arr[0];
		int maxArea = 0;
		for (int i = 1; i < arr.length; i++) {
			int w = i - maxIndex;
			int l = Integer.min(maxHeight, arr[i]);
			System.out.println("w:" + w + "l:" + l);
			maxArea = Integer.max(maxArea, w * l);
			System.out.println(maxArea);
			if (arr[i] > maxHeight) {
				maxIndex = i;
				maxHeight = arr[i];
			}
		}
		return maxArea;
	}

	public int solve1(int[] arr) {
		int max = 0;
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int area = Integer.min(arr[i], arr[j]) * (j - i);
			max = Integer.max(max, area);
			if (arr[i] > arr[j]) {
				j--;
			} else {
				i++;
			}
		}
		return max;
	}
}
