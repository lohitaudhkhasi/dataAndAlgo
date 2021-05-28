package com.ds.assignment.amazon;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// A Java program to introduce Binary Tree
public class BinaryTree {
	public Node root;

	BinaryTree(int key) {
		root = new Node(key);
	}

	public BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		System.out.println(tree.depth(tree.root));
		
	}

	public int depth(Node node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = 1 + depth(node.left);
		int rightDepth = 1 + depth(node.right);
		int max = Integer.max(leftDepth, rightDepth);
		return max;
	}
}