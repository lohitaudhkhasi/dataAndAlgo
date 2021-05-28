package com.ds.assignment.backtracking;

public class Question11 {

	public static void main(String[] args) {
		String s = "1?1?";
		Question11 q = new Question11();
		q.solve(s.toCharArray(), 0);
	}

	public void solve(char[] arr, int index) {
		if (index > arr.length - 1) {
			System.out.println(new String(arr));
			return;
		}
		// System.out.println(index);
		if (arr[index] == '?') {
			arr[index] = '0';
			solve(arr, index + 1);
			arr[index] = '1';
			solve(arr, index + 1);
			arr[index] = '?';
		} else {
			solve(arr, index + 1);
		}
	}
}
