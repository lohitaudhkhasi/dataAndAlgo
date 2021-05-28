package com.ds.assignment.amazon;

//Generate all pair of abcd
public class MatrixChainMultiplication {
	public static void main(String[] args) {
		String str = "abcd";
		
		mcm(str);
	}
	
	public static void mcm(String str) {
		/*
		int n = 4;
		for (int d = 1; d < n; d++) {
			for(int i = 0; i < n-d;i++) {
				int j = i+d;
				for(int k = i ; k < j ;k++) {
					System.out.println("((" + str.charAt(i) + "," + str.charAt(k) + "},(" + str.charAt(k+1) + "," + str.charAt(j) + "})");
				}
			}
		} */
		int n = 4;
		for (int d = 2; d < n ;d++ ) {
			for (int i = 0; i <= n - d; i++) {
				StringBuilder s = new StringBuilder();
				s.append("(");
				if ( i > 0) {
					s.append(str.substring(0, i));
				}
				s.append("(" + str.substring(i, i + d) + ")");
				s.append(str.substring(i+d));
				s.append(")");
				System.out.println(s);
			}
		}
	}
}
