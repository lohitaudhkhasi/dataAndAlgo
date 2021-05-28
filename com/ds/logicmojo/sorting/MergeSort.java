package com.ds.logicmojo.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr= { 3, 4, 6, 5, 8, 7};
		int[] result = new int[arr.length];
		MergeSort m = new MergeSort();
		m.mergeSort(arr, result, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}
	
	public void mergeSort(int[] arr,int[] result, int low, int high) {
		if (high == low) {
			return;
		}
		int mid = low + (high-low)/2;
		
		mergeSort(arr, result, low, mid);
		mergeSort(arr, result, mid+1, high);
		merge(arr, result, low, mid, high);
	}

	private void merge(int[] arr, int[] result, int low, int mid, int high) {
		int k = low;
		int i = low;
		int j = mid +1;
		while  ( i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				result[k++] = arr[i++];
			} else {
				result[k++] = arr[j++];
			}
		}
		while ( i <= mid) {
			result[k++] = arr[i++];
		}
		while( j <= high) {
			result[k++] = arr[j++];
		}
		for(i = low; i <= high; i++) {
			arr[i] = result[i];
;		}
	}
}
