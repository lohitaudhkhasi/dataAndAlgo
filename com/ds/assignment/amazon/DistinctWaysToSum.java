package com.ds.assignment.amazon;

import java.util.Arrays;

public class DistinctWaysToSum {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 10};
		int n = 13;
		DistinctWaysToSum d = new DistinctWaysToSum();
		d.distinctWays(arr, n);
	}
	
	public int distinctWays(int[] arr, int n) {
		if(n < 0) {
			return 0;
		} 
		if (n == 1) {
			return 0;
		}
		int sum[] = new int[n+1];
		sum[0] = 1;
 
		for(int i = 1; i <= n; i++) {
			if (i-3 >= 0) {
				sum[i]+= sum[i-3];
			}
			if (i-5 >= 0) {
				sum[i]+= sum[i-5];
			}
			if (i-10 >= 0) {
				sum[i]+= sum[i-10];
			}
		}
		System.out.println(Arrays.toString(sum));
		return sum[n];
	}
}
