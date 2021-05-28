package com.ds.assignment.amazon;

public class PeakInBitonicSeries {
	public static void main(String[] args) {
		int[] arr = { 35, 25, 20, 5 };
		int start = 0; 
		int end = arr.length - 1;
		int peakIndex = -1;
		while(start <= end ) {
			int mid = start + (end-start)/2;
			if (mid == 0) {
				if (arr[mid] > arr[mid + 1]) {
					peakIndex =  mid;
				} else {
					peakIndex = mid + 1;
				}
				break;
			} else if (mid == arr.length -1) {
				if (arr[mid] > arr[mid - 1]) {
					peakIndex =  mid;
				} else {
					peakIndex = mid - 1;
				}
				break;
			} else if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
				peakIndex = mid;
				break;
			} else if (arr[mid] < arr[mid +1] && arr[mid] > arr[mid-1]) {
				start = mid + 1;
			} else if (arr[mid] < arr[mid -1] && arr[mid] > arr[mid +1]) {
				end = mid -1;
			}
		}
		System.out.println(peakIndex);
	}

}
