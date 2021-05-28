package com.ds.assignment.amazon;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		String str = "BACBAB";
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		l.lps(str);
		l.gpaFilling(str);
		
	}
	
	public void lps(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for(int len = 0; len < n ; len++) {
			for(int i = 0, j = len; j < n; i++,j++) {
				if (len == 0) {
					dp[i][j] = 1;
				} else if (len == 1) {
					dp[i][j]= str.charAt(i) == str.charAt(j) ? 2: 1;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2 + dp[i+1][j-1];
					} else {
						dp[i][j] = Integer.max(dp[i][j-1], dp[i+1][j]);
					}
				}
			}
		}
		for(int i= 0; i < n; i++) {
			for (int j= 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		printLCS(dp, 0, n-1, str);
		System.out.println(dp[0][n-1]);
	}
	
	public void printLCS(int[][] dp, int i, int j, String str) {
		if ( i > j) {
			System.out.println("");
		}
		if ( i == j) {
			System.out.println( " " + str.charAt(i) + " ");
		}
		if(str.charAt(i) == str.charAt(j)) {
			 printLCS(dp, i + 1, j - 1,str);
			 System.out.println(str.charAt(i) + " ");
		} else {
			if (dp[i][j-1] > dp[i+1][j]) {
				printLCS(dp, i, j - 1,str);	
			} else {
				printLCS(dp, i + 1, j ,str);
			}
		}
	}
	
	public void gpaFilling(String str) {
		int n = str.length();
		int count = 1;
		int[][] dp = new int[n][n];
		for(int len = 0; len < n; len++) {
			for(int i = 0, j = len; j < n  ; i++,j++) {
				dp[i][j] = count++;
			}
		}
		for(int i= 0; i < n; i++) {
			for (int j= 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
