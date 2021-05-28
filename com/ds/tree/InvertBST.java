package com.ds.tree;

public class InvertBST {

	private static int sum = 0;

	public static void main(String args[]) {
		BSTNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
		// int[] keys = { 1, 2 };
		for (int key : keys) {
			root = BSTNode.insert(root, key);
		}
		System.out.println("------Level Traversal---------");
		LevelOrderTraversal.levelOrderTraversal(root);
		System.out.println("------Post Order---------");

		postOrder(root);
		System.out.println("-------Inverted-----------");
		BSTNode inverted = invertTree(root);
		System.out.println("-------Level of Inverted-----------");
		LevelOrderTraversal.levelOrderTraversal(inverted);
	}

	public static BSTNode postOrder(BSTNode root) {
		if (root != null) {
			postOrder(root.right);
			root.data += sum;
			System.out.println(root.data);
			sum = root.data;
			postOrder(root.left);
		}
		return root;
	}

	public static int rightSum(BSTNode root) {
		if (root == null) {
			return 0;
		} else {
			root.data += rightSum(root.right);
		}
		return root.data;
	}

	public static BSTNode invertTree(BSTNode root) {
		if (root != null) {
			invertTree(root.left);
			invertTree(root.right);
			BSTNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	public static BSTNode invertedBST(BSTNode n, int data) {
		if (n == null) {
			return n = new BSTNode(data);
		}
		if (data <= n.data) {
			n.right = invertedBST(n.right, data);
		} else {
			n.left = invertedBST(n.left, data);
		}
		return n;
	}
}
