package com.ds.assignment.backtracking;

public class NQueensProblem {

	public int[][] c;
	public int n;

	public static void main(String[] args) {
		NQueensProblem q = new NQueensProblem(5);
		if (!q.setQueen(0)) {
			System.out.println("No feasible solution");
		} else {
			q.printQueen();
		}
	}

	public NQueensProblem(int n) {
		this.c = new int[n][n];
		this.n = n;
	}

	public void printQueen() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == 1) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	public boolean setQueen(int colIndex) {
		if (colIndex == n) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (isPlaceValid(i, colIndex)) {
				c[i][colIndex] = 1;
				if (setQueen(colIndex + 1)) {
					return true;
				}
				c[i][colIndex] = 0;
			}
		}
		return false;
	}

	private boolean isPlaceValid(int row, int colIndex) {
		for (int i = 0; i < n; i++) {
			if (c[i][colIndex] == 1 || c[row][i] == 1) {
				return false;
			}
		}
		int col = colIndex;
		int r = row;
		while (col >= 0 && r < n) {
			if (c[r++][col--] == 1) {
				return false;
			}
		}
		col = colIndex;
		r = row;
		while (col < n && r < n) {
			if (c[r++][col++] == 1) {
				return false;
			}
		}
		col = colIndex;
		r = row;
		while (col >= 0 && r >= 0) {
			if (c[r--][col--] == 1) {
				return false;
			}
		}
		col = colIndex;
		r = row;
		while (col < n && r >= 0) {
			if (c[r--][col++] == 1) {
				return false;
			}
		}
		return true;
	}
}
