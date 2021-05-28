package com.ds.assignment.amazon;

public class CheckAlmostPalindrome {

	public static void main(String[] args) {
		String s = "raceacar";
		CheckAlmostPalindrome c = new CheckAlmostPalindrome();
		boolean isPalindrome = c.isAlmostPalindrome(s, 0, s.length() -1, Boolean.FALSE);
		System.out.println(isPalindrome);
	}
	
	public boolean isAlmostPalindrome(String s, int left, int right, boolean removed) {
		if (s.length() < 2) {
			return true;
		}
		while ( left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				if (removed) {
					return false;
				} else {
					return isAlmostPalindrome(s, left + 1, right, true) ||
							isAlmostPalindrome(s, left, right -1, true);
				}
			}
			left++;
			right--;
		}
		return true;
	}
}


