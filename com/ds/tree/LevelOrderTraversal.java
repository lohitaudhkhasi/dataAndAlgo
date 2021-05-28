package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
		for (int key : keys) {
			root = tree.insert(root, key);
		}
		tree.setRoot(root);
		levelOrderTraversal(tree.getRoot());
	}

	public static void levelOrderTraversal(BSTNode n) {
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(n);
		while (!queue.isEmpty()) {
			BSTNode node = queue.poll();
			System.out.println(node.data);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
}
