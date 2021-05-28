package com.ds.assignment.week1;

import java.util.LinkedList;
import java.util.List;

public class Question7 {

	public static void main(String[] args) {
		// int[] arr = { 0, 1, 0, 0, 1, 1, 0, 1, 0, 1 };
		int[] arr = { 0, 0, 1, 0, 1, 0, 0 };
		Question7 q = new Question7();
		q.maxSubarrayEqualZeroOne(arr);
	}

	/**
	 * 0 - 1,0 1 - 2,0 2 - 2,1 3 - 3,1 4 5 6
	 * 
	 * @param arr
	 */
	public void maxSubarrayEqualZeroOne(int[] arr) {
		int countZero = 0;
		int countOne = 0;
		int max = Integer.MIN_VALUE;
		int[] maxIndex = new int[2];
		List<Integer> l = new LinkedList<Integer>();
		l.add(-1);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZero++;
			} else if (arr[i] == 1) {
				countOne++;
			}
			if (countZero - countOne == 0) {
				for (Integer val : l) {
					int length = i - (val + 1);
					if (length > max) {
						maxIndex[0] = val + 1;
						maxIndex[1] = i;
					}
					max = Math.max(length, max);
				}
			}
		}
		System.out.println("[" + maxIndex[0] + "..." + maxIndex[1] + "]");
	}
}
