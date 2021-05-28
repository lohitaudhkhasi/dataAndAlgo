package com.ds.assignment.amazon;

public class LongestSubstringEqualHalf {

	public static void main(String[] args) {
		int[] str = { 1, 4, 2, 1, 2, 4};
		LongestSubstringEqualHalf l = new LongestSubstringEqualHalf();
		l.maxInt(str);

	}

	public int maxInt (int[] str) {
		int max = Integer.MIN_VALUE;
		for (int i = 0 ; i < str.length; i++) {
			for ( int j = i+1; j < str.length; j=j+2) {
				System.out.println(i + "," + (j));
				if (j-i +1 > max && isValid(str, i, j)) {
					max = Integer.max(max, j -i + 1 );
				}
			}
		}
		System.out.println(max);
		return max;
	}
	public static boolean isValid(int[] arr, int i, int j) {
		int suml = 0;
		int sumr = 0;
		while(i <= j) {
			suml+= arr[i++];
			sumr+= arr[j--];
		}
		return sumr == suml ? true: false;
	}
}
