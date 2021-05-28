package com.ds.assignment.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RightSideBinarySearchTree {

	public int desiredLevel = 1;
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.left.right = new Node(7);
		tree.root.left.left.right.left = new Node(8);
		RightSideBinarySearchTree t = new RightSideBinarySearchTree();
		t.rightView(tree.root);
		System.out.println();
		t.rsv(tree.root);
		System.out.println();
		
		t.rsvUsingDFS(tree.root, 1);
		System.out.println();
		t.preOrder(tree.root);
	}

	/**
	 * If root is null, return null
	 *  Loop over each level to print the right most element 
	 *  Initialize Poll counter = 0;
	 *  NumberOfInserted = 1
	 *  count = 0;
	 *  We would need to keep track in queue,
	 *  while ( numberOfInserted > 0){
	 *  	a. How much elements are getting in queue at each level till poll counter != numberOfInserted,
	 *  		This we would store in count; 
	 *        - help to define when particular level is ending
	 *      b. Poll data and Increment Poll counter 
	 *      c. If poll counter == numberOfInserted, print data
	 *      d. Reset poll counter to 0,and replace numberofInserted with count and count = 0 
	 *  }
	 * @param root
	 */
	public void rightView(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int pollCounter = 0;
		int numInserted = 1;
		int count = 0;
		
		while (numInserted > pollCounter) {
			Node n = queue.poll();
			pollCounter++;
			if (n.left != null) {
				queue.add(n.left);
				count++;
			}
			if (n.right != null) {
				queue.add(n.right);
				count++;
			}
			if (pollCounter == numInserted) {
				System.out.print(n.key + " ");
				numInserted = count;
				pollCounter= 0;
				count = 0;
			}
		}
	}
	
	public void rsv(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			int length = q.size();
			int count = 0;
			while (count < length ) {
				Node n = q.poll();
				count++;
				if (count == length) {
					System.out.print(n.key + " ");
				}
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
		}
	}
	
	public void rsvUsingDFS(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == desiredLevel) {
			System.out.print(root.key + " ");
			desiredLevel++;
		}
		rsvUsingDFS(root.right, level + 1);
		rsvUsingDFS(root.left, level + 1);
	}
	
	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);


		
	}
}
