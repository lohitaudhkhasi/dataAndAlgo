package com.ds.assignment.bits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubSet {
	// Try to find which bit is on, if that bit is on, take that number
	static int get_bit(int num, int bit) {
		int temp = (1 << bit);
		temp = temp & num;
		if (temp == 0) {
			return 0;
		}
		return 1;
	}

	static void get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
		int subsets_count = (int) (Math.pow((double) 2, (double) v.size()));
		for (int i = 0; i < subsets_count; ++i) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < v.size(); ++j) {
				if (get_bit(i, j) == 1) {
					int x = v.get(j);
					set.add(x);
				}
			}
			sets.add(set);
		}
	}

	public static void main(String[] args) {
		Integer[] myints = new Integer[] { 2, 3, 4 };
		List<Integer> v = new ArrayList<Integer>();
		for (Integer i : myints) {
			v.add(i);
		}
		List<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();

		get_all_subsets(v, subsets);

		System.out.println("****Total*****" + subsets.size());
		for (int i = 0; i < subsets.size(); ++i) {
			System.out.print("{");
			for (Integer it : subsets.get(i)) {
				System.out.print(it + ", ");
			}
			System.out.println("}");
		}
		System.out.println("****Total*****" + subsets.size());
	}
}