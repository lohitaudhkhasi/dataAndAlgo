package com.ds.assignment.amazon;

import java.util.List;
import java.util.ArrayList;

public class WordLadder {

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		List<String> dict = new ArrayList<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("cog");
		WordLadder wd = new WordLadder();
		wd.wd(start, end,  dict, 0);
		//int result = wd.minWd(start, end, dict);
	}
	
	//public int minWd(String start, String end, List<String> dict) {
		//wd(start, end, 0, dict, 0);
	//}
	
	public void wd(String start, String end, List<String> dict, int count) {
		if (start.equals(end)) {
			System.out.println(count);
			return;
		}
		for(int index = 0 ; index < start.length(); index++) {
			if(start.charAt(index) != end.charAt(index)) {
				for(int i = 0; i < dict.size(); i++) {
					String newStart = replaceString(start, dict.get(i).charAt(index),index);
					if (valid(newStart, end, index, dict)) {
						wd(newStart, end, dict, count++);
					}
				}
			} else {
				wd(start, end, dict, count);
			}
		}

	}
	
	public String replaceString(String str, char ch, int index) {
		return str.substring(0, index) + ch + str.substring(index + 1);
	}
	
	public boolean valid(String start, String end, int index, List<String> dict) {
		if (!dict.contains(start)) {
			return false;
		}
		return true;
	}
}
