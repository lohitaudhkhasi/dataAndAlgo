package com.ds.assignment.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
     }
     
      public String toString() {
    	  return Integer.toString(val);
      }
 }
  
public class Solution2 {
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(9);
		l.add(3);
		l.add(7);
		l.add(1);
		l.add(8);
		l.add(12);
		l.add(10);
		l.add(20);
		l.add(15);
		l.add(18);
		l.add(5);
		
		/*l.add(1);
		l.add(2);
		l.add(3); */
		Solution2 s = new Solution2();
		TreeNode tree = s.buildTree(l);
		s.levelOrder(tree);
	}
	
    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = null;
        if (A.size() > 0) {
            Integer[] arr = A.toArray(new Integer[A.size()]);
            root = createCartesianTree(arr, 0 , arr.length);
        }
        return root;
    }
  
	
	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		queue.add(root);
		int count = 1;
		List<Integer> level = new ArrayList<>();

		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			level.add(n.val);
			count--;
			
			if (n.left != null) queue.add(n.left);
			if(n.right != null) queue.add(n.right);
			
			if (count == 0) {
				result.add(level);
				level =  new ArrayList<>();
				count = queue.size();
			}
		}
		for(List<Integer> list : result) {
			System.out.println(list);
		}
	}

    public TreeNode createCartesianTree(Integer[] arr, int start, int end){
    	if (start == end ) {
    		return null;
    	}
   // 	System.out.println(start + "," + end);
        int minIndex = findMinIndex(arr, start, end);
     //   System.out.println(minIndex);
        TreeNode root = new TreeNode(arr[minIndex]);
        if (minIndex -1 >= 0) {
        	root.left = createCartesianTree(arr, start, minIndex );
        }
        if (minIndex + 1 <= arr.length -1) {
        	root.right = createCartesianTree(arr, minIndex + 1, end);
        }
        return root;
    }
    
    public int findMinIndex(Integer[] arr, int start, int end){
        Integer min = arr[start];
        Integer minIndex = start;
        for (int i = start ; i < end; i++){
            if (arr[i] < min) {
            	minIndex = i;
            	min = arr[i];
            }
        }
        return minIndex;
    }
}
