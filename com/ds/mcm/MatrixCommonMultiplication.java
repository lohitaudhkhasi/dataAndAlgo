package com.ds.mcm;

import com.ds.util.Util;

/**
 * 
 * @author lohaudhk
 *
 */
public class MatrixCommonMultiplication {

	public static void main(String[] args) {
		int[] input = { 10, 20, 30, 20 };
		int[][] t = new int[input.length][input.length];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = -1;
			}
		}
		Util.display(t);
		System.out.println(mcm(input, 1, input.length - 1, t));
	}

	public static int mcm(int[] input, int i, int j, int[][] t) {
		System.out.println("i:" + i + ",j:" + j);
		if (i >= j) {
			return 0;
		}
		if (t[i][j] != -1) {
			return t[i][j];
		}
		int min = Integer.MAX_VALUE - 1;
		for (int k = i; k <= j - 1; k++) {
			System.out.println("Calling from i:" + i + ",j:" + j);
			int temp = mcm(input, i, k, t) + mcm(input, k + 1, j, t) + input[i - 1] * input[k] * input[j];
			System.out.println("Called i:" + i + ",j:" + j);
			System.out.println("Min:" + min + "temp:" + temp);
			min = Math.min(min, temp);
		}
		return t[i][j] = min;
	}
}
