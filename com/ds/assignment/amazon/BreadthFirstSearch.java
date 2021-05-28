package com.ds.assignment.amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		BreadthFirstSearch s = new BreadthFirstSearch();
		s.bfs(tree.root);
		System.out.println();
		s.bfs2(tree.root);
		System.out.println();
		s.bfsQueue(tree.root);
		System.out.println();
		s.inOrder(tree.root);
	}

	public void bfs(Node node) {
		int h = height(node);
		for (int i = 1; i <= h; i++) {
			printGivenlevel(node, i);
		}
	}

	public void printGivenlevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.key + " ");
		} else {
			printGivenlevel(root.left, level - 1);
			printGivenlevel(root.right, level - 1);
		}
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = 1 + height(root.left);
		int rightHeight = 1 + height(root.right);
		int max = Integer.max(leftHeight, rightHeight);
		return max;
	}

	public void bfs2(Node root) {
		int level = 1;
		while (printLevel(root, level)) {
			level++;
		}
	}

	public boolean printLevel(Node node, int level) {
		if (node == null) {
			return false;
		}
		if (level == 1) {
			System.out.print(node.key + " ");
			return true;
		}
		boolean leftHeight = printLevel(node.left, level - 1);
		boolean rightHeight = printLevel(node.right, level - 1);
		return leftHeight || rightHeight;
	}

	public void bfsQueue(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			Node node = q.poll();
			System.out.print(node.key + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}
	
	public void inOrder(Node root) {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while ( current != null || stack.size() > 0) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.key + " ");
			current = current.right;
		}
	}
}
