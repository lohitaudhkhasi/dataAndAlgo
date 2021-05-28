package com.ds.assignment.week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question33 {

	public static void main(String[] args) {
		Question33 q = new Question33();
		int[] arr = { 10, 68, 75, 7, 21, 12 };
		q.qsort(arr);
	}

	public void qsort(int[] arr) {
		List<String> numbers = Arrays.asList("10", "68", "75", "7", "21", "12");
		Collections.sort(numbers, (a, b) -> Integer.valueOf(b + a) - Integer.valueOf(a + b));
		System.out.println(numbers);
	}
}
