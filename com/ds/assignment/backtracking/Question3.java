package com.ds.assignment.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Question3 {

	static int mat[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 } };
	static int m = mat[0].length;
	static int n = mat[0].length;
	int[][] visited;
	static List<String> path = new LinkedList<>();

	public Question3() {
		visited = new int[m][n];
	}

	public static void main(String[] args) {
		Question3 q = new Question3();
		int d = q.solve(0, 0, 5, 7, 0, 0);
		System.out.println("Longest path:" + d);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		for (String i : path) {
			String pair = i.replace('_', ',');
			System.out.println("{" + pair + ") --> ");
		}
	}

	public int solve(int i, int j, int xd, int yd, int md, int d) {
		if (mat[i][j] == 0) {
			return 0;
		}
		if (i == xd && j == yd) {
			return Integer.max(md, d);
		}

		// if Safe, move right
		System.out.println("i:" + i + ",j:" + j);
		visited[i][j] = 1;
		path.add(i + "_" + j);
		if (isValid(i + 1, j)) {
			md = solve(i + 1, j, xd, yd, md, d + 1);
		}
		if (isValid(i, j + 1)) {
			md = solve(i, j + 1, xd, yd, md, d + 1);
		}
		if (isValid(i - 1, j)) {
			md = solve(i - 1, j, xd, yd, md, d + 1);
		}
		if (isValid(i, j - 1)) {
			md = solve(i, j - 1, xd, yd, md, d + 1);
		}
		visited[i][j] = 0;
		path.remove(i + "_" + j);
		return md;
	}

	public boolean isValid(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n) {
			return false;
		}
		if (mat[x][y] == 0 || visited[x][y] != 0) {
			return false;
		}
		return true;
	}

}
