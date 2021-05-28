package com.ds.assignment.amazon;

public class MergeSort {

	
	public static void mergeSort( int[] arr, int start, int end) {
		if (end- start < 2) {
			return;
		}
		
		// partition the array 
		int mid = start + (end - start)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		merge(arr, start, mid, end);
	}
	
	public static void merge(int[] input, int start, int mid, int end) {
		if (input[mid -1] <= input[mid] ) {
			return ;
		}
		int i = start;
		int j = mid;
		int tempIndex = 0;
		
		int[] temp = new int[end-start];
		while( i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];

		}
	}
}
