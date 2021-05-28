package com.ds.assignment.amazon;

import java.util.Queue;
import java.util.LinkedList;

public class Island {
	static int[][] directions = {
			{-1, 0},
			{0,1},
			{1,0},
			{0, -1}
	};
	
	public static void main(String[] args) {
		int[][] a = {{1, 1, 1, 0, 0},
				{1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{0, 0, 0, 1, 1}};
		Island i = new Island();
		int count = i.getCount(a);
		System.out.println(count);
	}
	
	
	/*
	 * We can use BFS Search to see the area of expansion. 
	 * Help to determine radius.
	 * 
	 * Keep track of visited and unvisited nodes
	 * We would need adjacent matrix for the same
	 * 
	 * Scan equal index sequentially 
	 * Edges are water and 1 are islands. 
	 * Boundary : Length of array 
	 * 
	 * Keep track of counter : numI
	 * Start with 0, 0 ,
	 * 
	 *   Check if index is unvisited and equal to 1
	 *   	Initialize a queue everytime. 
	 *   	Make function to see expansion radius of 1 
	 *   	increment num1 ++
	 *   	Stop when queue is empty
	 *   Move to next node.
	 *   
	 *  T : O(?) - Need to check
	 *  S : O(n)
	 *  
	 */
	public int getCount(int [][] arr) {
		int l = arr.length;
		int b = 0;
		if (l > 0) {
			b = arr[0].length;
		}
		if ( l == 0 || b ==0 ) {
			return 0;
		}
		// All nodes are initialized to 0.
		//int[][] visited = new int[l][b];
		int islands = 0;
		for (int row = 0; row < l; row++) {
			for (int col = 0; col < b; col++) {
				if (arr[row][col] == 1) {
					markIsland(arr, l, b, row, col);
					islands++;
				}
			}
		}
		return islands;
	}

	class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;	
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	public void markIsland(int[][] arr, int length, int breadth, int row, int col) {
		Queue<Pair> queue = new LinkedList<>();
		Pair p = new Pair(row, col);
		queue.add(p);
		arr[row][col] = 0;
		while (queue.size() > 0) {
			Pair pair = queue.poll();
			for(int i = 0 ; i < directions.length; i++) {
				int r = directions[i][0];
				int c = directions[i][1];
				int nextR = pair.getX() + r;
				int nextC = pair.getY() + c;
				if (nextR >= 0 && nextR < length && nextC >=0 && nextC < breadth && arr[nextR][nextC] != 0) {
					queue.add(new Pair(nextR,nextC));
					arr[nextR][nextC] = 0;
				}
			}
		}
	}
}
