package com.ds.assignment.amazon;

public class BinarySearchTree {
	Node root;
	
	public Node insert(Node root, int key) {
		if (root == null) {
			root = new Node(key);
		}
		if (key < root.key) {
			root.left = insert(root.left, key);
		} else if(key > root.key){
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	public void init(BinarySearchTree tree) {
		if (tree == null) {
			return;
		}
		root = tree.insert(root, 12);
		root = tree.insert(root, 7);
		root = tree.insert(root, 18);
		root = tree.insert(root, 5);
		root = tree.insert(root, 9);
		root = tree.insert(root, 8);
		root = tree.insert(root, 18);
		root = tree.insert(root, 14);
		root = tree.insert(root, 25);
		root = tree.insert(root, 15);
		root = tree.insert(root, 16);
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.init(tree);
		boolean isValid = tree.isValid(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(isValid);
	}
	
	public boolean isValid(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (min < root.key && root.key < max) {
			return isValid(root.left, min, root.key) && isValid(root.right, root.key , max);
		} else {
			return false;
		}
	}
}

