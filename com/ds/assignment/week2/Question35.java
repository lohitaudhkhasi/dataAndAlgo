package com.ds.assignment.week2;

import java.util.LinkedList;
import java.util.List;

public class Question35 {
	public static void main(String[] args) {
		Question35 q = new Question35();
		int[] a = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
		int[] b = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };
		System.out.println("Max sum:" + q.maxSum(a, b, a.length, b.length));
	}

	public int maxSum(int[] a, int[] b, int m, int n) {
		int i = 0;
		int j = 0;
		int a_sum = 0;
		int b_sum = 0;
		int alc_index = -1;
		int blc_index = -1;
		int maxSum = 0;
		List<Integer> list = new LinkedList<>();
		while (i < m && j < n) {
			if (a[i] > b[j]) {
				b_sum = b_sum + b[j];
				j++;
			} else if (a[i] < b[j]) {
				a_sum = a_sum + a[i];
				i++;
			} else {
				if (maxSum + a_sum >= maxSum + b_sum) {
					for (int index = alc_index + 1; index < i; index++) {
						list.add(a[index]);
					}
					maxSum = maxSum + a_sum;
				} else {
					for (int index = blc_index + 1; index < j; index++) {
						list.add(b[index]);
					}
					maxSum = maxSum + b_sum;
				}
				maxSum = maxSum + a[i];
				list.add(a[i]);
				// System.out.printf("%d-%d | %d,", i, j, a[i]);
				// System.out.println("List:" + list);
				alc_index = i;
				blc_index = j;
				i++;
				j++;
				a_sum = 0;
				b_sum = 0;
			}
			// System.out.println(i + "," + j);
		}
		while (i < m) {
			a_sum += a[i++];
		}
		while (j < n) {
			b_sum += b[j++];
		}
		if (maxSum + a_sum >= maxSum + b_sum) {
			for (int index = alc_index + 1; index < m; index++) {
				list.add(a[index]);
			}
			maxSum = maxSum + a_sum;
		} else {
			for (int index = blc_index + 1; index < n; index++) {
				list.add(b[index]);
			}
			maxSum = maxSum + b_sum;
		}
		// System.out.println("List:" + list);
		for (int k : list) {
			System.out.printf(k + "->");
		}
		System.out.println();
		return maxSum;
	}
}
