package com.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {
	// This problem is also known as nearly sorted array
	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 2, 8, 9, 10 };
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (minHeap.size() > k) {
				arr[i - k - 1] = minHeap.poll();
			}
			minHeap.add(arr[i]);
		}
		for (int i = 0; i < k; i++) {
			arr[arr.length - (k - i) - 1] = minHeap.poll();
		}
		System.out.println(Arrays.asList(arr));
	}
}
