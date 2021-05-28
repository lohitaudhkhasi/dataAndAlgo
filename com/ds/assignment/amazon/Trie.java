package com.ds.assignment.amazon;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private TrieNode root;
	
	public Trie () {
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple", trie.getRoot());
		System.out.println();
	}
	
	public void insert(String text, TrieNode root) {
		if ( text.length() == 0) {
			root.setEnd(true);
			return;
		}
		Character key = text.charAt(0);
		TrieNode nextNode = null;
		if (!root.containsKey(key) ) {
			nextNode = new TrieNode();
			root.put(key, nextNode);
		} else {
			nextNode = root.getKey(key);
		}
		insert(text.substring(1), nextNode);
	}
	
	public boolean search(String text, TrieNode root) {
		if (text.length() == 0 || root.isEnd()) {
			return true;
		}
		// TODO: Need to implement it later 
		return false;
	}
}

class TrieNode {
	private boolean end;
	private Map<Character, TrieNode> keys = new HashMap<>(); 
	
	public void setEnd(boolean end) {
		this.end = end;
	}
	
	public boolean isEnd() {
		return end;
	}
	
	public boolean containsKey(Character key) {
		return keys.containsKey(key);
	}
	
	public void put(Character key, TrieNode node) {
		keys.put(key, node);
	}
	
	public TrieNode getKey(Character key) {
		return keys.get(key);
	}
}
