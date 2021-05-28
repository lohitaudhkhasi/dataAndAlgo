package com.ds.tree;

public class BSTNode {
	Integer data;
	BSTNode left;
	BSTNode right;

	public BSTNode(Integer data) {
		this.data = data;
	}

	public static BSTNode insert(BSTNode node, Integer n) {
		if (node == null) {
			node = new BSTNode(n);
			return node;
		}
		if (n > node.data) {
			node.right = insert(node.right, n);
		} else {
			node.left = insert(node.left, n);
		}
		return node;
	}

}
