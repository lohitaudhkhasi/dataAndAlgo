package com.ds.tree;

public class ValidBST {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
		for (int key : keys) {
			root = tree.insert(root, key);
		}
		tree.setRoot(root);
		System.out.println(isValid(tree.getRoot()));
	}

	public static boolean isValid(BSTNode n) {
		return isValid(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValid(BSTNode n, int min, int max) {

		if (n == null)
			return true;
		if (n.data < min || n.data > max) {
			System.out.println("Checking data " + n.data + " between " + min + " and " + max);
			return true;
		}
		System.out.println("Checking data " + n.data + " between " + min + " and " + max);
		return isValid(n.left, min, n.data) && isValid(n.right, n.data + 1, max);
	}

}
