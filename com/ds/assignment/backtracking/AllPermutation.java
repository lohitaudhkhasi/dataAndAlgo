package com.ds.assignment.backtracking;

public class AllPermutation {

	public static void main(String[] args) {
		String test = "nui";
		char[] arr = test.toCharArray();
		AllPermutation a = new AllPermutation();
		a.solve(arr, 0);
	}

	public void solve(char[] arr, int index) {
		if (index == arr.length) {
			System.out.println(new String(arr));
		}
		for (int i = index; i < arr.length; i++) {
			swap(arr, index, i);
			solve(arr, index + 1);
			swap(arr, index, i);
		}
		// return false;
	}

	private void swap(char[] arr, int index, int i) {
		char temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}

}
