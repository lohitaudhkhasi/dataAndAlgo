package com.ds.assignment.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// exhaustive search or combination
// print all permutations of given array
public class Backtracking1 {
	public static void main(String[] args) {
		Backtracking1 b1 = new Backtracking1();
		int[] arr = {1, 2, 3, 4};
	//	b1.print(arr, 0);
		System.out.println();
		//b1.print(arr,new ArrayList<>(), new boolean[arr.length]);
		b1.printCombination(arr, 0,3, new ArrayList<>());
	}

	public void printCombination(int[] arr, int index, int k, List<Integer> list) {
		if (arr.length - index < k) {
			return;
		}
		if (k == 0 ){
			System.out.println(Arrays.toString(list.toArray()));
			return;
		}
		for(int i = index; i < arr.length ; i++) {
			list.add(arr[i]);
			printCombination(arr, i + 1, k -1, list);
			list.remove(list.size() -1);
		}
	}
	
	public void print(int[] arr, int start) {
		if (start == arr.length) {
			System.out.println(Arrays.toString(arr));
		}
		for (int i = start; i < arr.length; i++) {
			swap(arr, start, i);
			print(arr, start +1);
			swap(arr, i, start);
		}
	}
	
	public void print(int[] arr,List<Integer> list, boolean[] used) {
		if (list.size() == arr.length) {
			System.out.println(Arrays.toString(list.toArray()));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!used[i]) {
				list.add(arr[i]);
				used[i] = true;
				print(arr, list, used);
				used[i] = false;
				list.remove(list.size() -1);
			}
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

//Pseudo code 
/*
 * function (input, partial, output) {
 * if (isValidSolution(partial) {
 * 		ProcessPartialSolution(partial)
 * 			return
 * }
 *  candidates = generateCandidates(input, partial) 
 *  for c in candidate {
 *  	addCandidate ( c , input, partial) ;
 *  	function (input, partial, output);
 *  	removeCandidate( c, input, partial);
 *  }
 *  
 */

// backtracking is used to generate permutation and combinations
// in perm, sequence is important, not in combination 



