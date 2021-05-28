package com.ds.assignment.week1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Print all sub-array with sum 0
public class Question3 {
	int sum = 0;

	public static void main(String[] args) {
		int[] arr = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2, 4 };
		Question3 q = new Question3();
		q.printArrSum(arr);
	}

	public void printArrSum(int[] arr) {
		Map<Integer, List<Integer>> multiMap = new HashMap<>();
		List<Integer> val = new LinkedList<>();

		// Sum is zero at -1
		val.add(-1);
		multiMap.put(0, val);

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (multiMap.containsKey(sum)) {
				List<Integer> list = multiMap.get(sum);
				for (Integer value : list) {
					System.out.println("[" + (value + 1) + "..." + i + "]");
				}
				list.add(i);
			} else {
				val = new LinkedList<>();
				val.add(i);
				multiMap.put(sum, val);
			}
		}
	}
}
