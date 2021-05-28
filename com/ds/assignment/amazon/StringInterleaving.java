package com.ds.assignment.amazon;

public class StringInterleaving {
	
	public static void main(String[] args) {
		String s1 = "AB";
		String s2 = "XY";
		StringInterleaving si = new StringInterleaving();
		si.printSI(s1, s2, 0, 0, "");
	}
	
	public void printSI(String s1, String s2, int i, int j, String path) {
		if (path.length() == s1.length() + s2.length()) {
			System.out.println(path);
			return;
		}
		if ( i < s1.length()) {
			printSI(s1, s2, i + 1, j, path + s1.charAt(i));
		}
		if ( j < s2.length()) {
			printSI(s1, s2, i, j + 1, path + s2.charAt(j));
		}
	}
}
