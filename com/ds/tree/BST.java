package com.ds.tree;

public class BST {

	private BSTNode root;

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode n) {
		this.root = n;
	}

	public BSTNode insert(BSTNode node, int n) {
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

	public BSTNode search(BSTNode n) {

		return null;
	}

	public void delete(BSTNode n) {

	}

}
