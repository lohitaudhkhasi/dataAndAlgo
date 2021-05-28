package com.ds.assignment.recursion;

public class Recursion1 {
	public static void main(String[] args) {
		Recursion1 r1 = new Recursion1();
		System.out.println(r1.palindrome("t"));
		int[] arr = {2,3,4,6};
		System.out.println(r1.checkSeq(arr));
		System.out.println(r1.sum(2154));
	}
	
	public int sum(int num) {
		if (num < 10) {
			return num;
		}
		return num%10 + sum(num/10);
	}
	
	public boolean palindrome (String s) {
		return palindrome(s, 0, s.length() -1);
	}
	
	public boolean palindrome(String s, int start, int end) {
		if (start > end) {
			return true;
		}
		if (s.length() == 1) {
			return true;
		}
		if (s.charAt(start) == s.charAt(end)){
			return palindrome(s, start + 1, end -1);
		} else {
			return false;
		}
	}
	
	public boolean checkSeq(int[] arr) {
		return checkSeq(arr, arr.length -1);	
	}

	public boolean checkSeq(int[] arr, int index) {
		if (index == 0) {
			return true;
		}
		return (arr[index] == arr[index - 1] + 1)
			&& checkSeq(arr, index -1);
	}
}
