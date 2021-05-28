package com.ds.assignment.recursion;

/* Combination
(n ) = (n-1) + (n-1) 
(k)0 = (k-1) + (k) 

(n) = 1     (n) = 1 
(n) 		(0)

C(n, k) = c(n-1, k) + c(n-1, k-1)
c(n,n) = 1 
*/


public class CombinationBinomial {
	public int[][] dp;
	int n;
	int k;
	public static void main(String[] args) {
		CombinationBinomial c = new CombinationBinomial(4,2);
		System.out.println(c.recur(c.n, c.k));
		System.out.println(c.recurMemo(c.n, c.k));
		System.out.println(c.bottomUp(c.n, c.k));
	}
	
	CombinationBinomial(int n, int k){
		dp = new int[n+1][k+1];
		this.n = n;
		this.k = k;
	}
	
	public int recur(int n, int k) {
		if ( n == k || (k == 0 )) {
			return 1;
		}
		int result = recur(n-1, k-1) + recur(n-1, k);
		return result;
	}
	
	public int recurMemo(int n, int k) {
		if ( n == k || (k == 0 )) {
			return 1;
		}
		if (dp[n][k] != 0) {
			return dp[n][k];
		}
		int result = dp[n][k] = recur(n-1, k-1) + recur(n-1, k);
		return result;
	}
	
	public int bottomUp(int n, int k) {
		for ( int i = 0; i <= n; i++) {
			for ( int j = 0; j <= k; j++) {
				if (i ==j) {
					dp[i][j] = 1;
				}
				if ( i == 0) {
					dp[i][j] = 0;
				}
				if ( j == 0) {
					dp[i][j] = 1;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		return dp[n][k];
	}
	
}
