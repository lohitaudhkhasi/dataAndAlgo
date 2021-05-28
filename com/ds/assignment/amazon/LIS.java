package com.ds.assignment.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LIS {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 5, 2, 7, 6};
		LIS lis = new LIS();
		lis.lis(arr, arr.length);
	}
	
	public int lis(int[] arr, int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		for(int i = 1 ; i < n ; i++) {
			int max = 1;
			for (int j = 0 ; j < i; j++) {
				if (arr[i] > arr[j]) {
					max = Integer.max(max, lis[j]);
				}
			}
			lis[i] = max + 1;
		}
		System.out.println(Arrays.toString(lis));
		
		print(lis, arr);
		return lis[n-1];
	}
	
	class Pair{
		public int value;
		public int index;
		public int length;
		public String psf;
		
		public Pair(int value, int index, int length, String psf) {
			super();
			this.value = value;
			this.index = index;
			this.length = length;
			this.psf = psf;
		}
		
	}

	private void print(int[] lis, int[] arr) {
		int max = lis[lis.length -1];
		Queue<Pair> queue = new LinkedList();
		int i = lis.length -1;
		while (lis[i] == max) {
			queue.add(new Pair(arr[i], i, lis[i], arr[i] + " "));
			i--;
		}
		
		while(!queue.isEmpty()) {
			Pair rem = queue.poll();
			if (rem.length == 1) {
				System.out.println(rem.psf);
			}
			for(int j = rem.index -1; j >= 0; j--) {
				if (lis[j] == rem.length -1 && arr[j] < rem.value) {
					queue.add(new Pair(arr[j], j, lis[j], arr[j] + " " + rem.psf));
				}
			}
		}
	}
	
	
}
