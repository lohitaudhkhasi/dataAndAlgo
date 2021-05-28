package com.ds.assignment.week1;

import java.util.HashSet;
import java.util.Set;

public class Question16 {

	public static void main(String[] args) {
		Question16 q = new Question16();
		int[] arr = { 2, 0, 2, 1, 4, 3, 1, 0 };
		q.printLongest(arr);
	}

	public void printLongest(int[] arr) {
		int min = -1;
		int max = -1;
		int i = -1;
		int j = -1;
		int maxLength = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int index = 0; index < arr.length; index++) {
			i++;
			while (!set.contains(arr[index])) {
				j++;
				set.add(arr[index++]);
			}
			// set.remove(arr[index]);
			int length = j - i + 1;
			if (length > maxLength) {
				min = i;
				max = j;
			}
			i = index - 1;
			j = index - 1;
		}
		System.out.println(min + ", " + max);
	}
}
