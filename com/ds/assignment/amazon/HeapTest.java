package com.ds.assignment.amazon;

import java.util.PriorityQueue;

public class HeapTest {
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 1, 3, 25};
		HeapTest h = new HeapTest();
		h.sort(arr);
		h.reverseSort(arr);
	}
	
	public void sort(int[] arr) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i : arr) {
			queue.add(i);
		}
		while(queue.size() > 0) {
			Integer n = queue.poll();
			System.out.print(n + " ");
		}
	}
	
	public void reverseSort(int[] arr) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
			return b -a ;
		});
		for (int i : arr) {
			queue.add(i);
		}
		while(queue.size() > 0) {
			Integer n = queue.poll();
			System.out.print(n + " ");
		}
	}
}
