package com.ds.assignment.backtracking;

public class PrintAllBrackets {

	private static int num = 0;

	public static void main(String[] args) {
		PrintAllBrackets p = new PrintAllBrackets();
		p.print(5, 0, 0, "");
	}

	public void print(int n, int left, int right, String path) {
		if (left >= n && right >= n) {
			System.out.println(path);
			System.out.println(++num);
		}
		if (left < n) {
			print(n, left + 1, right, path + " { ");
		}
		if (right < left) {
			print(n, left, right + 1, path + " } ");
		}
	}
}
