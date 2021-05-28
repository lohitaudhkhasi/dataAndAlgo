package com.ds.assignment.backtracking;

public class KnightTourProblem {

	private final static int BOARD_SIZE = 8;
	private int[][] board;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		KnightTourProblem k = new KnightTourProblem();
		k.findSol();
	}

	public KnightTourProblem() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
		initBoard();
	}

	private void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	public void findSol() {
		board[0][0] = 0;
		if (solve(1, 0, 0)) {
			printChessBoard(board);
		} else {
			System.out.println("No solution found");
		}
	}

	private void printChessBoard(int[][] board2) {
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2.length; j++) {
				System.out.print(" " + board2[i][j]);
			}
			System.out.println();
		}
	}

	public boolean solve(int stepCount, int x, int y) {
		if (stepCount == (BOARD_SIZE * BOARD_SIZE)) {
			return true;
		}
		for (int i = 0; i < xMoves.length; i++) {
			int newX = x + xMoves[i];
			int newY = y + yMoves[i];
			if (isValid(newX, newY)) {
				board[newX][newY] = stepCount;
				if (solve(stepCount + 1, newX, newY)) {
					return true;
				}
				board[newX][newY] = Integer.MIN_VALUE;
			}
		}
		return false;
	}

	private boolean isValid(int newX, int newY) {
		if (newX < 0 || newX >= BOARD_SIZE) {
			return false;
		}
		if (newY < 0 || newY >= BOARD_SIZE) {
			return false;
		}
		if (board[newX][newY] != Integer.MIN_VALUE) {
			return false;
		}
		return true;
	}

}
