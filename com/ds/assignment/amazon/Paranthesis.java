package com.ds.assignment.amazon;

import java.util.Arrays;

public class Paranthesis {

	char[] p = { '(', ')'};
	public static void main(String[] args) {
		int n = 3;
		char[] arr = new char[n*2];
		Paranthesis p = new Paranthesis();
		p.printParanthesis(arr, 0, 0, 0, 3,"");
	}
	
	public void printParanthesis(char[] arr, int index, int lp, int rp, int n, String path) {
		if ( lp >= n && rp >= n) {
			System.out.println(path);
			return;
		}
		if (lp < n) {
			printParanthesis(arr, index+1, lp + 1, rp, n, path + "(");
		}
		if ( rp < lp) {
			printParanthesis(arr, index+1, lp, rp + 1, n,  path + ")");
		}
	}
	
	public boolean valid(char[] arr, int lp, int rp, int n) {
		//System.out.println("Validating:" + Arrays.toString(arr));
		if (lp > n || rp > n) {
			return false;
		}
		if (lp < rp) {
			return false;
		}
		int clp = 0;
		int crp= 0;
		for(int i = 0 ; i < lp + rp; i++) {
			if (arr[i] == '(') {
				clp++;
			} else {
				crp++;
			}
			if (crp > clp) {
				return false;
			}
		}
		return true;
	}
}
