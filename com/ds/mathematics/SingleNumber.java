package com.ds.mathematics;

public class SingleNumber {

	public static void main(String args[]) {
		int[] k = { 2, 2, 1 };
		System.out.println(singleNumber(k));
	}

	public static int singleNumber(int[] s) {
		if (s.length == 1) {
			return s[0];
		}
		for (int i = 1; i < s.length; i++) {
			s[i] = s[i - 1] ^ s[i];
		}
		return s[s.length - 1];
	}
}
