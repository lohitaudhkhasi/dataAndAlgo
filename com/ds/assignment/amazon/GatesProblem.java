package com.ds.assignment.amazon;

public class GatesProblem {

	static int[][] directions = {
			{-1, 0},
			{0, 1},
			{1, 0},
			{0, -1}
	};
	
	public static void main(String[] args) {
		GatesProblem p = new GatesProblem();
		int[][] arr = {
				{Integer.MAX_VALUE, -1 , 0, Integer.MAX_VALUE},
				{ Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
				{Integer.MAX_VALUE, -1 , Integer.MAX_VALUE, -1},
				{0, -1 , Integer.MAX_VALUE, Integer.MAX_VALUE}
		};
		p.solve(arr);
		p.printArray(arr);
	}
	
	public void printArray(int [][] arr) {
		for (int i = 0; i < arr.length ; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void solve(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		for(int i = 0; i < m ; i++) {
			for (int j = 0; j < n ; j++) {
				if (arr[i][j] == 0) {
					markRooms(arr, i, j, 0, m , n);
				}
			}
		}
	}
	
	public void markRooms(int[][]arr, int row, int col, int current, int m , int n) {
		if (row < 0 || row >= m || col < 0 || col >= n || arr[row][col] < current) {
			return;
		}
		arr[row][col] = current;
		current++;
		for (int i = 0; i < directions.length; i++) {
			int r = directions[i][0];
			int c = directions[i][1];
			markRooms(arr, row + r, col + c, current, m, n);
		}
	}
}
