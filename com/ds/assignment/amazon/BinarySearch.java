package com.ds.assignment.amazon;

public class BinarySearch {
	public static void main(String[] args) {
		BinarySearch s = new BinarySearch();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(s.search(arr, 20, 0, arr.length - 1));
		System.out.println(s.search1(arr, 20));
	}

	public boolean search(int[] arr, int key, int start, int end) {
		if (start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return true;
		} else if (arr[mid] > key) {
			return search(arr, key, start, mid - 1);
		} else {
			return search(arr, key, mid + 1, end);
		}
	}

	public boolean search1(int[] arr, int key) {
		int lp = 0;
		int rp = arr.length - 1;
		while (lp <= rp) {
			int mid = (lp + rp) / 2;
			if (arr[mid] == key) {
				return true;
			} else if (arr[mid] > key) {
				rp = mid - 1;
			} else {
				lp = mid + 1;
			}
		}
		return false;
	}
}
