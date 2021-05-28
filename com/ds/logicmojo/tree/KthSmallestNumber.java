package com.ds.logicmojo.tree;

import com.ds.assignment.amazon.BinaryTree;
import com.ds.assignment.amazon.Node;

// Inorder traversal of binary search tree gives sorted data 
public class KthSmallestNumber {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
	}
	
	public void InOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		InOrderTraversal(root.left);
		System.out.println(root.key);
		InOrderTraversal(root.right);
	}
	
	public void reverseInorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		InOrderTraversal(root.right);
		System.out.println(root.key);
		InOrderTraversal(root.left);		
	}
}
