package com.ds.assignment.amazon;

public class FirstOccurence {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 2, 2, 2,2, 2, 2, 2, 3, 4};
		int key = 2;
		
		int start = 0;
		int result = -1;
		int end = arr.length -1;
		while(start <= end) {
			int mid = start + (end- start)/2;
			if (arr[mid] == key) {
				end = mid -1;
				result = mid;
			} else if ( key > arr[mid]) {
				start = mid+1;
			} else {
				end = mid -1;
			}
		}
		System.out.println("first occurence of key " + key + " is " + result);
	}
	
	
}
