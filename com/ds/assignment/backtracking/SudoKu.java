package com.ds.assignment.backtracking;

public class SudoKu {

	int[][] s;

	public static void main(String[] args) {
		SudoKu s = new SudoKu();
		if (s.solve(0)) {
			s.print();
		} else {
			System.out.println("no solution found");
		}
	}

	private void print() {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println("----------------------------");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print(" | ");
				}
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}

	public SudoKu() {
		init();
	}

	public void init() {
		s = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
	}

	public boolean solve(int index) {
		if (index == 81) {
			return true;
		}
		int row = index / 9;
		int col = index % 9;
		System.out.println(index + ",row:" + row + ",col:" + col);
		if (s[row][col] != 0) {
			return solve(index + 1);
		}
		for (int num = 1; num <= 9; num++) {
			if (isValid(num, row, col)) {
				s[row][col] = num;
				if (solve(index + 1)) {
					return true;
				}
				s[row][col] = 0;
			}
		}
		// s[row][col] = 0;
		return false;
	}

	private boolean isValid(int num, int row, int col) {
		int rBox = row / 3;
		int cBox = col / 3;
		for (int i = 3 * rBox; i < (3 * rBox) + 3; i++) {
			for (int j = 3 * cBox; j < (3 * cBox) + 3; j++) {
				if (s[i][j] == num) {
					return false;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (s[i][col] == num) {
				return false;
			}
			if (s[row][i] == num) {
				return false;
			}
		}
		return true;
	}

}
