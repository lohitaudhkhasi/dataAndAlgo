package com.ds.assignment.amazon;

import java.util.Queue;import javax.tools.ToolProvider;

import java.util.LinkedList;

public class ClassicKnapsack {
	public static void main(String[] args) {
		int[] weight = { 2, 3, 4, 5};
		int[] value = { 3, 4, 5, 6};
		int capacity = 5;
		ClassicKnapsack knpasack = new ClassicKnapsack();
		knpasack.kanpsack(weight, value, capacity);
	}
	
	/**
	 * 
	 * @param weight
	 * @param value
	 * @param capacity
	 */
	public void kanpsack(int[] weight, int[] value, int capacity) {
		int[][] dp = new int[weight.length +1][capacity +1];
		for(int i = 0; i < weight.length; i++) {
			dp[i][0] = 0;
		}
		for(int j = 0; j <= capacity ; j++) {
			dp[0][j] = 0;
		}
		for(int i = 1; i <= weight.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if ( weight[i-1] <= j) {
					dp[i][j] = Integer.max(dp[i - 1][j], value[i-1] + dp[i-1][j- weight[i-1]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		for(int i = 0; i <= weight.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		printElements(dp, weight, value, capacity);
	}

	class Pair{
		public int weight;
		public int capacity;
		public String psf;

		Pair(int weight, int capacity,String psf){
			this.weight = weight;
			this.capacity = capacity;
			this.psf = psf;

		}
		
		public String toString() {
			return "weight:" + weight + ",cap:" + capacity + ",psf:" + psf;
		}
	}
	
	/**
	 * 
	 * @param dp
	 * @param weight
	 * @param value
	 * @param capacity
	 */
	private void printElements(int[][] dp, int[] weight, int[] value, int capacity) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(weight.length, capacity, ""));
		
		while(!queue.isEmpty()) {
			Pair rem = queue.poll();
			if (rem.capacity == 0 && rem.weight == 0) {
				System.out.println(rem.psf);
				return;
			}
			// If we did not take this , it means value ocomes from above
			if (dp[rem.weight][rem.capacity] == dp[rem.weight-1][rem.capacity]) {
				queue.add(new Pair(rem.weight -1 , rem.capacity, rem.psf));
			} else {
				System.out.println(rem.weight -1 );
				queue.add(new Pair ( rem.weight -1 , rem.capacity - weight[rem.weight -1 ], weight[rem.weight-1] + " " + rem.psf));
			}
		}
	}
}
