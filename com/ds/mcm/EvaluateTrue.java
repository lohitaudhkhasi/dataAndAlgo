package com.ds.mcm;

public class EvaluateTrue {

	public static void main(String[] args) {
		char[] arr = { 'T', '&', 'F', '^', 'T' };
		System.out.println(solve(arr, 0, arr.length - 1, true));
	}

	public static int solve(char[] arr, int i, int j, boolean expr) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			if (arr[i] == 'T' && expr) {
				return 1;
			} else if (arr[i] == 'F' && !expr) {
				return 1;
			} else {
				return 0;
			}
		}
		int ans = 0;
		for (int k = i; k < j - 1; k += 2) {
			int leftTrue = solve(arr, i, k, true);
			System.out.println("leftTrue:" + leftTrue + "for i=" + i + ",k=" + k);
			int leftFalse = solve(arr, i, k, false);
			System.out.println("leftFalse:" + leftFalse + "for i=" + i + ",k=" + k);
			int rightTrue = solve(arr, k + 2, j, true);
			System.out.println("rightTrue:" + rightTrue + "for k=" + (k + 2) + ",j=" + j);
			int rightFalse = solve(arr, k + 2, j, false);
			System.out.println("rightFalse:" + rightFalse + "for k=" + (k + 2) + ",j=" + j);
			if (arr[k + 1] == '^') {
				if (expr) {
					ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue);
				} else {
					ans = ans + (leftTrue * rightTrue) + (leftFalse * rightFalse);
				}
			} else if (arr[k + 1] == '&') {
				if (expr) {
					ans = ans + (leftTrue * rightTrue);
				} else {
					ans = ans + (leftFalse * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
				}
			}
		}
		return ans;
	}
}
