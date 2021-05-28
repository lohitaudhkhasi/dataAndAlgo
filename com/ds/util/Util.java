package com.ds.util;

public class Util {

	public static void display(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { // this equals to the row in our matrix.
			for (int j = 0; j < matrix[i].length; j++) { // this equals to the column in each row.
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(); // change line on console as row comes to end in the matrix.
		}
	}
}
