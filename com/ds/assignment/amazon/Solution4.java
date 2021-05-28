package com.ds.assignment.amazon;

import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		int[] nums= {1,1,1,1,1};
		int target = 3;
		int result = s.findTargetSumWays(nums, target);
		System.out.println(result);
	}

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums){
            sum+= i;
        }
        if (S > sum || S < -sum){
            return 0;
        }
        int target = (sum + S) / 2;
        int n = nums.length + 1;
        int[][] dp = new int[n+1][target + 1];
        for(int i = 0; i <= n; i++) {
        	for (int j = 0; j <= target; j++) {
        		if(j==0) {
        			dp[i][j] = 1;
        		}
        		if (i==0) {
        			dp[i][j] = 0;
        		}
        	}
        }
        for(int i = 1; i < n; i++) {
        	for (int j = 1; j <= target; j++) {
        		if (nums[i-1] <= j) {
        			// we can exclude or include
        			dp[i][j] = dp[i -1][j] + dp[i-1][j - nums[i-1]];
        		} else {
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
        for(int i = 0; i <= n; i++) {
        	for (int j = 0; j <= target; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }        
        
        return dp[n][target];
    }
    }
