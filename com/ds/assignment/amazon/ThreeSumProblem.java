package com.ds.assignment.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 * @author lohaudhk
 *
 */
public class ThreeSumProblem {
	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4};
		int sum = 0;
		ThreeSumProblem ts = new ThreeSumProblem();
		ts.threeSum(arr, sum);
	}
	
	public List<List<Integer>> threeSum(int[] arr, int sum) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(arr);
		for(int i = 0; i < arr.length -2 ; i++) {
			if (i ==0 || (i > 0 && arr[i] != arr[i-1])) {
				int low = i+1;
				int high = 	arr.length -1;
				while ( low < high) {
					if ( arr[low] + arr[high] + arr[i] == sum) {
						list.add(Arrays.asList(arr[low], arr[high], arr[i]));
						while (low < high && (arr[low] == arr[low +1 ])) {
								low++;
							}
						while (low < high && (arr[high] == arr[high -1 ])) {
								high--;
							}
						low++;
						high--;
					} else if (arr[low] + arr[high] + arr[i] > sum ) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return list;
	}
}
