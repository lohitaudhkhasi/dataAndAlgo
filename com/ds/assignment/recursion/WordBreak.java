package com.ds.assignment.recursion;

import java.util.*;

public class WordBreak {
	static Set<String> dict = new HashSet<>(); 
	
	public static void main(String[] args) {
		dict.add("dog");
		dict.add("sand");
		dict.add("and");
		dict.add("cats");
		dict.add("cat");
		WordBreak w = new WordBreak();
		w.wordBreak("catsanddog");
	}
	
	public List<List<String>> wordBreak(String s){
		List<List<String>> words = new ArrayList<>();
		wordBreak(s, 0,words, new ArrayList<>());
		return words;
	}
	
	public int listSum(List<String> list) {
		int index = 0;
		for(String s : list) {
			index += s.length(); 
		}
		return index;
	}
	
	public void wordBreak(String s,int start, List<List<String>> words,List<String> tempResult){
		if (start == s.length()) {
			words.add(new ArrayList<String>(tempResult));
			return;
		}
		if (start == s.length()) {
			return;
		}
		for(int i= start; i< s.length(); i++) {
			String sub = s.substring(start, i+1);
			if (dict.contains(sub)) {
				tempResult.add(sub);
				wordBreak(s, i+1, words, tempResult);
				tempResult.remove(tempResult.size() -1);
			}
		}
	}
}
