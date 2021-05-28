package com.ds.assignment.amazon;

import java.util.*;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5,12, 13, 25};
		PythagoreanTriplet p = new PythagoreanTriplet();
		p.method1(arr);
		p.method2(arr);
		p.method3(arr);
	}
	
	// o(n3)
	public List<List<Integer>> method1(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		for ( int i = 0; i < arr.length ; i++) {
			for (int j = i+1; j < arr.length ; j++) {
				for (int k = j+1; k < arr.length ; k++) {
					if (arr[i]*arr[i] + arr[j]*arr[j] == arr[k]*arr[k]) {
						result.add(Arrays.asList(arr[i], arr[j], arr[k]));
					}
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> method2(int[] arr){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr);
		for(int i = arr.length -1 ; i >=2 ; i--) {
			int low = 0;
			int high = i-1;
			int sum = arr[i]*arr[i];
			
			while (low < high) {
				int leftsum = arr[low]*arr[low] + arr[high]*arr[high];
				if (leftsum == sum) {
					result.add(Arrays.asList(arr[low], arr[high], arr[i]));
					low++;
					high--;
				} else if (leftsum > sum ) {
					high--;
				} else {
					low++;
				}
			}
		}
		return result;
	}
	
	//o(max*max)
	public List<List<Integer>> method3(int[] arr){
		List<List<Integer>> result = new ArrayList<>();
		// Find the max of number and set frequency of the table
		int max = Integer.MIN_VALUE;
		if (arr.length > 1) {
			max = arr[0];
		}
		for (int i : arr) {
			max = Integer.max(max,  i);
		}
		int[] hash= new int[max+1];
		for(int i : arr) {
			hash[i]++;
		}
		
		for(int i = 1; i < max + 1; i++) {
			if(hash[i] == 0) {
				continue;
			}
			
			for(int j = i; j < max +1 ; j++) {
				if ((i == j && hash[i] == 1) || hash[j] == 0){
					continue;
				}
				
				int val = (int)Math.sqrt(i*i + j*j);
				
				if ((val * val) != (i*i + j*j)) {
					continue;
				}
				
				if(val > max) {
					continue;
				}
				
				if (hash[val] == 1) {
					result.add(Arrays.asList(i, j, val));
				}
			}
		}
		return result;
	}
}
