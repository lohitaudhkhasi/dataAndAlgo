package com.ds.assignment.recursion;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class TargetSum {
	
	public static void main(String[] args) {
		TargetSum t = new TargetSum();
		int[] arr = {10, 1,2, 7,6,1,5};
		Arrays.sort(arr);
		t.sum(arr, 8);
	}
	
	public void sum(int[] arr, int target) {
		targetSum(arr, target, 0, new LinkedList<>());
	}

	public void targetSum(int[] arr,int target, int start, List<Integer> set){
		if (target == 0){
			System.out.println(Arrays.toString(set.toArray()));
			return;
		}
		if (start == arr.length) {
			return;
		}
		for(int i = start; i < arr.length; i++) {
			int c = arr[i];
			if (c > target || ( i > start && c == arr[i-1])) {
				continue;
			}
			set.add(c);
			targetSum(arr, target -c , i + 1, set);
			set.remove(set.size() -1);
		}
	}
}
