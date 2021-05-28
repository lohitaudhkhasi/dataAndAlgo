package com.ds.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOccurence {

	public static void main(String[] args) {
		String input = "abcxxcbxxbcaaxxbac";
		String search = "abc";
		countAnagrams(input, search);
	}

	public static int countAnagrams(String input, String search) {
		int count = 0;
		// Distinct char map
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			Integer newVal = 0;
			if (charMap.containsKey(ch)) {
				newVal = charMap.get(ch) + 1;
			}
			charMap.put(ch, newVal);
		}
		return 0;
	}

	public static int updateMapAfterSearch(Map<Character, Integer> charMap, Character ch) {
		if (charMap.containsKey(ch)) {
			int newValue = charMap.get(ch);
			charMap.put(ch, newValue - 1);
		}

	}
}
