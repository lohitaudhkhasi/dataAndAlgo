package com.ds.assignment.recursion;

import java.util.Arrays;

public class PaintHouse {
	// red blue green
	// [house][color]
	static int[][] cost = {
			{17, 2, 17},
			{16, 16, 5},
			{14, 3, 9}};
	static final int RED = 0;
	static final int BLUE = 1;
	static final int GREEN = 2;
	
	static int[][] dp = new int[cost.length][cost[0].length + 1];
	
	public static void main(String[] args) {
		PaintHouse p = new PaintHouse();
		int result = Integer.MAX_VALUE;
		result = Math.min(result, p.minCost(cost, 0, RED));
		result = Math.min(result, p.minCost(cost, 0, BLUE));
		result = Math.min(result, p.minCost(cost, 0, GREEN));
		System.out.println(result);
		
		System.out.println(p.minCostBottomUp(cost));
	}
	
	
	public int minCost(int[][] cost, int i, int color) {
		if ( i == cost.length) {
			return 0;
		}
		switch(color){
		case RED : {
			int costBlue = minCost(cost, i + 1, BLUE);
			int costGreen = minCost(cost, i + 1, GREEN);
			return cost[i][color] + Math.min(costGreen, costBlue);
		}
		case BLUE :{
			int costRed = minCost(cost, i + 1, RED);
			int costGreen = minCost(cost, i + 1, GREEN);
			return cost[i][color] + Math.min(costGreen, costRed);			
		} 
		case GREEN :{
			int costBlue = minCost(cost, i + 1, BLUE);
			int costRed = minCost(cost, i + 1, RED);
			return cost[i][color] + Math.min(costRed, costBlue);
		}
		}
		return 0;
	}
	
	public int minCostBottomUp(int[][] cost) {
		int[][] dp = new int[cost.length + 1][3];
		int n = cost.length;
		if (cost.length == 0) {
			return 0;
		}
		for ( int i = 1; i <= n ; i++) {
			dp[i][RED] = cost[i-1][RED] + Math.min(dp[i-1][BLUE], dp[i-1][GREEN]);
			dp[i][GREEN] = cost[i-1][GREEN] + Math.min(dp[i-1][BLUE], dp[i-1][RED]);
			dp[i][BLUE] = cost[i-1][BLUE] + Math.min(dp[i-1][GREEN], dp[i-1][RED]);
		}
		
		int row = cost.length + 1;
		int col = 3;
		while 
		return Math.min(dp[n][RED], Math.min(dp[n][GREEN], dp[n][BLUE]));
	}
}
