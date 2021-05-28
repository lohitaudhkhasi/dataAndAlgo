package com.ds.assignment.amazon;

public class BinarySearchRange {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 5, 5, 5, 6, 7, 8, 9 };
		BinarySearchRange r = new BinarySearchRange();
		Pair p = r.solve(arr, 0, arr.length - 1, 5);
		System.out.println(p.getSp() + " , " + p.getSp());
	}

	public Pair solve(int[] arr, int start, int end, int key) {
		int firstPosition = binarySearch(arr, key, start, end);
		if (firstPosition == -1) {
			return new Pair(-1, -1);
		}
		int startPosition = firstPosition;
		int endPosition = firstPosition;
		int temps = 0;
		int tempe = 0;
		while (startPosition != -1) {
			temps = startPosition;
			startPosition = solve(arr, 0, startPosition - 1, key).getSp();
		}
		startPosition = temps;
		while (endPosition != -1) {
			tempe = endPosition;
			endPosition = solve(arr, endPosition + 1, end, key).getEp();
		}
		endPosition = tempe;
		return new Pair(startPosition, endPosition);
	}

	public int binarySearch(int[] arr, int key, int start, int end) {
		int left = start;
		int right = end;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}

class Pair {
	int sp;
	int ep;

	Pair(int sp, int ep) {
		this.sp = sp;
		this.ep = ep;
	}

	public int getSp() {
		return sp;
	}

	public int getEp() {
		return ep;
	}
}