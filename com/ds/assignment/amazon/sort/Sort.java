package com.ds.assignment.amazon.sort;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] barr = { 1, 2, -1, 2, 0, -3};
		Sort s = new Sort();
		s.bubbleSort(barr, barr.length);
		System.out.println(Arrays.toString(barr));
		int[] sarr = { 1, 2, -1, 2, 0, -3};
		s.selectionSort(sarr, sarr.length);
		System.out.println(Arrays.toString(sarr));
		int[] iarr = { 1, 2, -1, 2, 0, -3};
		s.insertionSort(iarr, iarr.length);
		System.out.println(Arrays.toString(iarr));
		int[] marr = { 1, 2, -1, 2, 0, -3};
		s.mergeSort(marr, 0, marr.length);
		System.out.println(Arrays.toString(marr));
	}
	
	public void bubbleSort(int[] arr, int n) {
		if (arr.length < 2) {
			return;
		}
		for ( int i = n-1 ; i >= 0 ; i--) {
			for ( int j = 0; j < i ; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public void selectionSort(int[] arr, int n) {
		if (arr.length < 2) {
			return;
		}
		int l = 0;
		for (int i = n-1; i >= 0; i--) {
			for (int j = 1; j <= i ; j++) {
				if (arr[j] > arr[l]) {
					l = j;
				}
			}
			swap(arr, l, i);
		}
	}
	
	public void insertionSort(int[] arr, int n) {
		if (arr.length < 2) {
			return;
		}
		for (int i = 1; i < n; i++) {
			int elem = arr[i];
			int j;
			for (j = i; j > 0 && elem < arr[j-1]; j--) {
					arr[j] = arr[j-1];
			}
			arr[j] = elem;
		}
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void mergeSort(int[] arr, int start, int end) {
		if (end - start < 2) {
			return;
		}
		
		int mid = (start + end)/2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr,  mid, end);
		merge(arr, start, mid, end);
	}
	
	public void merge(int[] arr, int start, int mid, int end) {
		if (end - start < 2) {
			return;
		}
		
		int i = start;
		int j = mid;
		int tempIndex = 0;
		int[] temp = new int[end-start];
		while ( i < mid && j < end) {
			temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		
		System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
		System.arraycopy(temp, 0, arr, start, tempIndex);
	}
}
