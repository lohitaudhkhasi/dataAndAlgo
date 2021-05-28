package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

// Implement Binary Tree
public class Tree {

	private Node root;
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node (int item){
			data = item;
			left = null;
			right = null;
		}
	}
	
	private Node insert(Node current , int key) {
		if (current == null) {
			return new Node(key);
		} else {
			if(key > current.data) {
				current.right = insert(current.right, key);
			} else if (key < current.data){
				current.left = insert(current.left, key);
			} else if (key == current.data) {
				return current;
			}
		}
		return current;
	}
	
	public void add(int value) {
	    root = insert(root, value);
	}
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add(10);
		t.add(12);
		t.add(6);
		t.add(15);
		t.printInOrder(t);
	}
	
	public void printInOrder(Tree t) {
		printInOrder(t.root);
	}
	
	
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node.data);
			printInOrder(node.right);
		}
	}
	
}
