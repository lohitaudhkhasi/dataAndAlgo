package com.ds.assignment.amazon;

public class StringEqualsEasy {

	public static void main(String[] args) {
		String a = "##acdd#";
		String b = "c#acb#d";
		StringEqualsEasy s = new StringEqualsEasy();
		boolean result = s.isEquals(a, b);
		System.out.println(result);
	}
	
	public boolean isEquals(String a, String b) {
		if (a.length() == 0 && b.length() == 0) {
			return true;
		}
		int i = a.length() -1;
		int j = b.length() -1;
		while (i >= 0 && j >= 0) {
			while ( i > -1 && a.charAt(i) == '#') {
				i-=2;
			}
			while (j > -1 && b.charAt(j) == '#') {
				j-=2;
			}
			if (i > -1 && j > -1) {
				if (a.charAt(i) != b.charAt(j)) {
					return false;
				}
				i--;
				j--;
			}
		}
		if (i >= 0 || j >= 0) {
			while (i > -1) {
				if (a.charAt(i--) != '#') {
					return false;
				}
			}
			while (j > -1) {
				if (b.charAt(j--) != '#') {
					return false;
				}
			}
		}
		return true;
	}
}
