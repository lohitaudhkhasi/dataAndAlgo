package com.ds.assignment.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSubset {
	public static void main(String[] args) {
		List<Integer> S = Arrays.asList(1, 2, 3);

		int n = S.size();
		PowerSubset p = new PowerSubset();
		List<Integer> s = new ArrayList<>();
		p.powerSet(S, s, n, 0);
		int[] arr = { 1, 2, 0 };
		Integer[] subset = new Integer[(int) Math.pow(2, arr.length)];
		System.out.println(p.ps(arr, subset, 0));
	}

	public void powerSet(List<Integer> S, List<Integer> s, int n, int index) {
		if (n == index) {
			System.out.println(s);
			return;
		}
		System.out.println("Index:" + index);
		powerSet(S, s, n, index + 1);
		s.add(S.get(index));
		System.out.println("Input:" + S.get(index));
		powerSet(S, s, n, index + 1);
		s.remove(S.get(index));
	}

	public int prod(Integer[] arr) {
		int prod = 1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != null) {
				if (arr[i] == 0) {
					return 0;
				}
				prod = prod * arr[i];
			}
		}
		return prod;
	}

	public int ps(int[] arr, Integer[] subset, int i) {
		if (i == arr.length) {
			return prod(subset);
		}
		subset[i] = null;
		int max = ps(arr, subset, i + 1);
		subset[i] = arr[i];
		int max1 = ps(arr, subset, i + 1);
		return Integer.max(max, max1);
	}

	public int maxProd(int[] arr, int n) {
		boolean zeroEncountered = false;
		boolean isEven = Boolean.TRUE;
		int minNegative = Integer.MAX_VALUE;
		int prod = 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				zeroEncountered = true;
			} else {
				if (arr[i] < 0) {
					isEven = !isEven;
					prod = prod * (-1 * arr[i]);
					if (arr[i] < minNegative) {
						minNegative = arr[i];
					}
				}
				prod = prod * arr[i];
			}
		}
		if (!isEven) {
			prod = prod / -1 * minNegative;
		}
		if (zeroEncountered) {
			prod = Integer.max(0, prod);
		}
		return prod;
	}
}
