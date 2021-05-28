package com.ds.assignment.amazon;

public class Node {
	public int key;
	public Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
	
	public String toString() {
		return "" + this.key;
	}
}