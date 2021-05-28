package com.ds.assignment.amazon;

public class MaxBookAllocation {
	public static void main(String[] args) {
		int[] pages = { 10, 20, 30, 40};
		int s = 2;
		MaxBookAllocation m = new MaxBookAllocation();
		System.out.println(m.bestAllocation(pages, s));
	}
	
	public int bestAllocation(int[] arr, int key) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			max = Math.max(max, arr[i]);
			sum+= arr[i];
		}
		int start = max;
		int end = sum;
		int result = -1;
		while (start <= end) {
			int mid = start + (end-start)/2;
			if (isValid(arr, mid, key)) {
				result = mid;
				end = mid - 1; 
			} else {
				start = mid  + 1;
			}
		}
		// Find partition with result as limit
		int load = 0;
		int maxResult = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			load+= arr[i];
			if (load > result) {
				load = arr[i];
			}
			maxResult = Integer.max(maxResult, load);
		}
		return maxResult;
	}

	private boolean isValid(int[] arr, int threshold, int key) {
		int limit = 0;
		int count = 1;
		for(int i = 0 ; i < arr.length ;i++) {
			limit+= arr[i];
			 if(limit > threshold) {
				 limit = arr[i];
				 count= count+1;
			 }
			 if (count > key) {
				 return false;
			 }
		}
		return true;
	}
}
