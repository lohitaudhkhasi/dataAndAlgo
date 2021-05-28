package com.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinAndMaxHeap {

	public static void main(String[] args) {
		int[] arr = { 4, -1, 10, 7, 6, 5 };
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : arr) {
			minHeap.add(i);
		}
		// Minimum
		System.out.println(minHeap.poll());
		// Second mimimum
		System.out.println(minHeap.poll());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i : arr) {
			maxHeap.add(i);
		}
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(thirdSmallestElement(arr));
	}

	public static Integer thirdSmallestElement(int[] arr) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i : arr) {
			maxHeap.add(i);
			if (maxHeap.size() > 3) {
				maxHeap.poll();
			}
		}
		return maxHeap.poll();
	}
}
