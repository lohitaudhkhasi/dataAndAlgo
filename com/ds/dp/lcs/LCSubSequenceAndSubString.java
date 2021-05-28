package com.ds.dp.lcs;

import com.ds.util.Util;

public class LCSubSequenceAndSubString {

	public static void main(String[] args) {
		String x = "acdefg";
		String y = "bcefg";
		int[][] t = new int[x.length() + 1][y.length() + 1];
		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(LCS(x, y, x.length(), y.length(), t));
		Util.display(t);
		System.out.println(LCSBottomUp(x, y, x.length(), y.length()));
		LCSBottomUpPrint(x, y, x.length(), y.length());

		System.out.println(LCSBottomUpSubstring(x, y, x.length(), y.length()));
	}

	public static int LCS(String x, String y, int m, int n, int[][] t) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (t[m][n] != -1) {
			return t[m][n];
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return t[m][n] = 1 + LCS(x, y, m - 1, n - 1, t);
		} else {
			return t[m][n] = Math.max(LCS(x, y, m, n - 1, t), LCS(x, y, m - 1, n, t));
		}
	}

	public static int LCSBottomUp(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			t[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
					sb.append(x.charAt(i - 1));
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		Util.display(t);
		System.out.println(sb.toString());
		return t[m][n];
	}

	public static String LCSBottomUpPrint(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			t[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
					// sb.append(x.charAt(i - 1));
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		Util.display(t);
		while (m > 0 && n > 0) {
			if (x.charAt(m - 1) == y.charAt(n - 1)) {
				sb.append(x.charAt(m - 1));
				m--;
				n--;
			} else {
				if (t[m][n - 1] > t[m - 1][n]) {
					n--;
				} else {
					m--;
				}
			}
		}
		System.out.println("Bottom up:" + sb.toString());
		return sb.toString();
	}

	public static int LCSBottomUpSubstring(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			t[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = 0;
				}
			}
		}
		Util.display(t);
		return t[m][n];
	}
}