package com.ds.assignment.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ArraysCopy {
	public static void main(String[] args) {
		ArraysCopy a = new ArraysCopy();
		a.lengthOfLongestSubstring("abcbacbb");
		a.solve1("abcbacbb");
		int[] nums = { -1, 2 , -3};
		System.out.println(a.kadane(nums));
		System.out.println(a.numBits(7));
	}
	
	public int[] solve(int[] arr, int target) {
		if (arr == null) {
			throw new IllegalArgumentException("No Solution");
		}
		Map<Integer, Integer> map = new HashMap<>();
		for ( int i = 0 ; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		for(int i = 0; i < arr.length;i++) {
			int compliment = target - arr[i];
			if (map.containsKey(compliment) && map.get(compliment)  != i){
				return new int[] { i, map.get(compliment)};
			}
		}
		throw new IllegalArgumentException("No two solution found");
	}

	public int getSum(int a, int b) {
		int ans = 0;
		int carry = 0;
		for(int i = 0; i < 32; i++) {
			int a1 = ( a >> i) & 1;
			int b1 = (b >> i) & 1;
			int c1 = (a1 ^ b1) ^ carry;
			carry = (a1 & b1) | ( a1 & carry) | (b1 & carry);
			if ( c1 == 1) ans |= ( 1 << i);
		}
		return ans;
	}
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			Character curr = s.charAt(j);
			if (map.containsKey(curr)) {
				i = Math.max(map.get(curr), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(curr, j + 1);
		}
		return ans;
	}
	
	public int solve1(String s) {
		Set<Character> set = new HashSet<>();
		int p1 = 0;
		int max = 0;
		for (int p2 = 0; p2 < s.length() ; p2++) {
			Character curr = s.charAt(p2);
			if (set.contains(curr)){
				while(set.contains(curr)){
					set.remove(s.charAt(p1));
					p1++;
				}	
			}
			set.add(s.charAt(p2));
			max = Math.max(max, p2-p1 +1);	
		}
		return max;
	}
	
	public int kadane(int[] nums) {
		int maxSoFar = nums[0];
		int max = nums[0];
		for ( int i = 1; i < nums.length; i++) {
			maxSoFar= Integer.max( nums[i], maxSoFar + nums[i]);
			if ( maxSoFar > max) {
				max = maxSoFar;
			}
		}
		return max;
	}
	
	public int numBits(int num){
		int sum = 0;
		int mask = 1;
		for (int i = 0; i < Integer.SIZE ; i++) {
			if ((num & mask) > 0) {
				sum++;
			}
			mask <<= 1;
		}
		return sum;
	}
	
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return Collections.emptyList();
		}
		Arrays.sort(intervals, (a,b) -> {
			return a[0] - b[0];
		});
		
		LinkedList<int[]> result = new LinkedList<>();
		for (int[] interval : intervals ) {
			if (result.isEmpty() || result.getLast()[1] < interval[0]) {
				result.add(interval);
			} else {
				result.getLast()[1] = Integer.max(result.getLast()[1] , interval[1]);
			}
		}
		int[][] resultArr = result.toArray(new int[result.size()][]);
		PriorityQueue<Integer> lo = new PriorityQueue<>(1, (a,b) -> {
			return b.compareTo(a);
		});
		return resultArr;
	}
}
