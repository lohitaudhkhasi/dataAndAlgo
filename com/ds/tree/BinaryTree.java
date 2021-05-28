package com.ds.tree;

public class BinaryTree {

	int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Integer[] arr = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };

		BSTNode bst = add(null, arr, 0);
		BinaryTree bt = new BinaryTree();
		System.out.println(bt.maxPathSum(bst));
	}

	public static BSTNode add(BSTNode root, Integer[] arr, int i) {
		if (i < arr.length) {
			BSTNode temp = new BSTNode(arr[i]);
			root = temp;

			root.left = add(root.left, arr, 2 * i + 1);
			root.right = add(root.right, arr, 2 * i + 2);
		}
		return root;
	}

	class Res {
		int val;

		public Res(int val) {
			this.val = val;
		}
	}

	public int maxPathSum(BSTNode root) {
		maxSum(root);
		return result;
	}

	public int maxSum(BSTNode root) {
		if (root == null || root.data == null) {
			return 0;
		}
		int l = maxSum(root.left);
		int r = maxSum(root.right);

		int temp = Math.max(Math.max(l, r) + root.data, root.data);

		int ans = Math.max(temp, root.data + l + r);
		result = Math.max(result, ans);
		System.out.println("temp:" + temp + ",l:" + l + ",r:" + r + ",root.data:" + root.data + ",ans:" + ans
				+ ",result:" + result);
		return temp;
	}
}
