package com.ds.assignment.week2;

import java.util.HashSet;
import java.util.Set;

public class Question45 {
	public static void main(String[] args) {
		Question45 q = new Question45();
		int[] arr = { 1, 5, 2, 2, 2, 5, 5, 4 };
		q.pairWithDiffK(arr, -3);
	}

	public void pairWithDiffK(int[] arr, int diff) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] + diff)) {
				System.out.println(arr[i] + "," + (arr[i] + diff));
			}

			if (set.contains(arr[i] - diff)) {
				System.out.println(arr[i] + "," + (arr[i] - diff));
			}
			set.add(i);
		}
	}
}
