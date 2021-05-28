package com.ds.assignment.amazon;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class MaxSubStringLength {
	 public static void main(String[] args) {
		 MaxSubStringLength m = new MaxSubStringLength();
		 //String s = "abccabb";
		 String s = "abcbda";
		 int width = m.length2(s);
		 System.out.println(width);
	 }
	 
	 /*
	  * 
	  */
	 public int length(String s) {
		 if (s.length() == 0) {
			 return 0;
		 }
		 int ws = 0;
		 int max = Integer.MIN_VALUE;
		 int i = 0;
		 Set<Character> set = new HashSet<>();
		 while ( i < s.length()) {
			 char c = s.charAt(i);
			 if (set.contains(c)) {
				 for (int j = i - ws; j < i ; j++) {
					 set.remove(s.charAt(j));
					 ws--;
					 if (s.charAt(j) == c) {
						 break;
					 }
				 }
			 }
			 set.add(c);
			 i++; // 3
			 ws++; // 3
			 max = Integer.max(ws, max);
		 }
		 return max;
	 }
	 
	 public int length2(String s) {
		 if (s.length() == 0) {
			 return 0;
		 }
		 int ws = 0;
		 int left = 0; 
		 int right = 0;
		 Map<Character, Integer> map = new HashMap<>();
				 
		 while ( right < s.length()) {
			 char c = s.charAt(right);
			 Integer oldIndex = null;
			 if ((oldIndex = map.get(c)) != null && oldIndex >= left) {
					 left = oldIndex + 1;
					 map.put(c, right);
			 } else {
				 map.put(c, right);
				 ws = Integer.max(ws, 1 + right - left);
			 }
			 right++;
		 }
		 return ws;
	 }
}
