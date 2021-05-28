package com.ds.assignment.amazon;

public class WordDict {
	
	public static void main(String[] args) {
		WordDict w = new WordDict();
		String words[] = {"WordDictionary","addWord","search"};
		for (String word : words) {
			w.addWord(word);
		}
		String[] searchWords = {"","bad","dad","mad","pad","bad",".ad","b.."};
		for(String word: searchWords) {
			System.out.println(w.search(word));
		}
	}
	
	//[null,null,null,null,false,true,true,true]
	class Node {
		boolean isTerminal;
		Node[] children;
		char data;
	
		public Node (char data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			children = new Node[128];
		}
	}

    Node root;
    
    /** Initialize your data structure here. */
    public WordDict() {
        	this.root = new Node ('\0', false);
    }
    
    public void addWord(String word) {
		Node curr = root;
		char[] arr = word.toCharArray();
		for (char ch : arr) {
			Node next = curr.children[ch];
			if (next == null) {
				next = new Node(ch, false);
				curr.children[ch] = next;
			}
			curr = curr.children[ch];
		}
		curr.isTerminal = true;
    }
    
	public boolean search(String word){
		return searchWord(word.toCharArray(), 0, root);
	}

	// if visted index = terminal and index != arr.length
	public boolean searchWord(char[] arr, int index, Node root) {
		if (index == arr.length) {
			return root.isTerminal;
		}
		char ch = arr[index];
		if ( ch == '.') {
			for ( int i = 0; i < 128; i++) {
				Node child = root.children[i];
				if ( child != null) {
					boolean flag = searchWord(arr, index+1 , child);
					if ( flag) {
						return true;
					}
				}
			}
			return false;
		} else {
			Node child = root.children[ch];
			if (child == null) {
				return false;
			} 
			searchWord(arr, index + 1, child);	
		}
		return false;
	}
}




/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */