package com.ds.assignment.backtracking;

public class Question1 {

	public static int[][] c;
	public int boardSize = 5;

	public Question1() {
		c = new int[boardSize][boardSize];
	}

	public static void main(String[] args) {
		Question1 q = new Question1();
		q.solve(c, 0);

	}

	private void printChessBoard() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
	}

	public void solve(int[][] c, int colIndex) {
		if (colIndex == boardSize) {
			printChessBoard();
			return;
			// return true;
		}
		for (int i = 0; i < boardSize; i++) {
			if (isPlaceValid(i, colIndex)) {
				c[i][colIndex] = 1;
				solve(c, colIndex + 1);
				c[i][colIndex] = 0;
				// return true;
			}
		}
	}

	// return false;
	// }

	private boolean isPlaceValid(int row, int colIndex) {
		for (int i = 0; i < boardSize; i++) {
			if (c[i][colIndex] == 1 || c[row][i] == 1) {
				return false;
			}
		}
		int col = colIndex;
		int r = row;
		while (col >= 0 && r < boardSize) {
			if (c[r++][col--] == 1) {
				return false;
			}
		}
		col = colIndex;
		r = row;
		while (col < boardSize && r < boardSize) {
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
		while (col < boardSize && r >= 0) {
			if (c[r--][col++] == 1) {
				return false;
			}
		}
		return true;
	}
}
