package com.ds.assignment.backtracking;

public class ColoringProblem {

	public int[][] adj;
	public int numberOfVertics;
	public static int[] colorVertex;
	public int numberOfColors;

	public static void main(String[] args) {
		int[][] adj = new int[][] { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 1, 0 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0 } };
		int colors = 3;
		ColoringProblem c = new ColoringProblem(adj, colors);
		if (c.solve(0)) {
			printNodes(colorVertex);
		} else {
			System.out.println("No solution found");
		}
	}

	private static void printNodes(int[] colorVertex2) {
		for (int i = 0; i < colorVertex2.length; i++) {
			System.out.println("Color of index " + (i + 1) + " is " + colorVertex[i]);
		}
	}

	public ColoringProblem(int[][] adj, int numberOfColors) {
		this.adj = adj;
		this.numberOfVertics = adj[0].length;
		colorVertex = new int[numberOfVertics];
		this.numberOfColors = numberOfColors;
	}

	public boolean solve(int nodeIndex) {
		if (nodeIndex == numberOfVertics) {
			return true;
		}
		for (int colorIndex = 1; colorIndex <= numberOfColors; colorIndex++) {
			if (isValidColor(nodeIndex, colorIndex)) {
				colorVertex[nodeIndex] = colorIndex;
				if (solve(nodeIndex + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValidColor(int nodeIndex, int colorIndex) {
		for (int i = 0; i < numberOfVertics; i++) {
			if (adj[nodeIndex][i] == 1 && colorVertex[i] == colorIndex) {
				return false;
			}
		}
		return true;
	}
}
