package com.ds.assignment.amazon;

public class QuickSort {
	// Divide and conquer algo 
	// recursive algo
	// evrything less than povit to left and pivot to right 
	// pivot would be in correct , left and right subarray are not partitoned 
	// Same thing for left array and same thing for right array 
	// Does it in place 
	
	public void quickSort(int[] arr, int start, int end) {
		if (end -start < 2) {
			return;
		}
		// Correct sorted position index
		int pivotIndex = partition(arr, start, end);
		 quickSort(arr, start , pivotIndex);
		 quickSort(arr, pivotIndex + 1,end);
		 
	}
	
	public int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end;
		
		while ( i < j) {
			while( i < j && arr[--j] >= pivot);
			if ( i < j) {
				arr[i] = arr[j];
			}
			while ( i < j && arr[++i] <= pivot);
			if ( i < j) {
				arr[j] = arr[i];
			}
		}
		arr[j] = pivot;
		return j;
	}
}
