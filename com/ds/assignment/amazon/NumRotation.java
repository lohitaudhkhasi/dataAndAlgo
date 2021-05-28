package com.ds.assignment.amazon;

// 2 3 4 5 7 11
public class NumRotation {
	public static void main(String[] args) {
		int[] arr = { 7, 11, 2, 3, 4, 5};
		
		int start = 0; 
		int end = arr.length -1;
		int numRotation = -1;
		while (start <= end) {
			int mid = start + (end-start)/2;
			int next = (mid + 1)%arr.length;
			int prev = (mid + arr.length -1)%arr.length;
			if (arr[mid] <= arr[prev] && arr[mid] < arr[next]) {
				numRotation = mid;
				break;
			} else if (start <= arr[mid]) {
				start = mid+1;
			} else if (arr[mid] <= arr[end]){
				end = mid-1;
			}
		}
		System.out.println(numRotation);
	}
}
