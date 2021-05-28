package com.ds.assignment.backtracking;

import java.util.Arrays;

public class HamiltonianCycle {
	public int[][] adj;
	public int numberOfVertex;
	public static int[] hp;

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 0, 0 }, { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 1 }, { 0, 1, 1, 0, 1 },
				{ 0, 0, 1, 1, 0 } };
		HamiltonianCycle hc = new HamiltonianCycle(matrix);
		hp[0] = 0;
		if (hc.solve(1)) {
			hc.printHamiltonianPath(hp);
		} else {
			System.out.println("No solution found");
		}
	}

	HamiltonianCycle(int[][] adj) {
		this.adj = adj;
		this.numberOfVertex = adj[0].length;
		hp = new int[adj.length];
	}

	public void printHamiltonianPath(int[] hp) {
		System.out.println(Arrays.toString(hp));
	}

	public boolean solve(int positionIndex) {
		if (positionIndex == numberOfVertex) {
			if (adj[hp[positionIndex - 1]][hp[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		for (int vertexIndex = 1; vertexIndex < numberOfVertex; vertexIndex++) {
			if (isValidVertex(vertexIndex, positionIndex)) {
				hp[positionIndex] = vertexIndex;
				if (solve(positionIndex + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isValidVertex(int vertexIndex, int positionIndex) {
		if (adj[hp[positionIndex - 1]][vertexIndex] == 0) {
			return false;
		}
		for (int i = 0; i < positionIndex; i++) {
			if (hp[i] == vertexIndex) {
				return false;
			}
		}
		return true;
	}
}
