package com.ds.assignment.amazon;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		t.findAnagrams("abcba", "abc");
		int[] nums = {3,2,1,5,6,4};
		t.findKthLargest(nums, 2);
		t.solve(4);
		List<String> a = Arrays.asList("12", "3", "01");
		Collections.sort(a, (i, j) -> {
			return (j+i).compareTo(i+j);
		});
		System.out.println(a);
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1,2, 3));
		list.add(Arrays.asList(4,5, 6));
		list.add(Arrays.asList(7,8, 9));
        boolean[][] visited = new boolean[3][3];
        ArrayList<Integer> result = new ArrayList<>();
        //visited[0][0] = true;
		t.spiralOrder(list);
	}

    public int[] x = { 0, 1, 0, -1} ;
    public int[] y = { 1, 0, -1, 0} ;
    
       public ArrayList<Integer> spiralOrder(List<List<Integer>> A) {
            if (A.size() == 0) {
                return new ArrayList<>();
            }
            int top = 0; 
            int bottom = A.size() -1 ;
            int left = 0;
            int right = A.get(0).size() -1 ;
            ArrayList<Integer> result  = new ArrayList<>();
            /*
                dir 0 - l to right 
                dir 1 - top to bottom
                dir 2 - left to right 
                dir 3 : bottom to top
            */
            int dir = 0;
            while( bottom >= top && right >= left){
                if (dir == 0){
                    for (int i = left; i <= right ; i++){
                        result.add(A.get(top).get(i));
                    }
                    dir = 1;
                    top++;
                } else if (dir == 1){
                    for(int i = top; i <= bottom ; i++){
                        result.add(A.get(i).get(right));
                    }
                    dir = 2;
                    right--;
                } else if ( dir == 2){
                    for (int i = right ; i >= left ; i--){
                        result.add(A.get(bottom).get(i));
                    }
                    dir = 3;
                    bottom--;
                } else if (dir == 3){
                    for(int i = bottom; i >= top; i-- ){
                        result.add(A.get(i).get(left));
                    }
                    dir = 0;
                    left++;
                }
            }
            return result;
        }


	
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length; i++){
            queue.add(nums[i]);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        return queue.poll();
    }
    
	public List<Integer> findAnagrams(String s, String p) {
		if (s.length() == 0){
			return Collections.emptyList();
		}
		if (s.length() < p.length()){
			return Collections.emptyList();
		}
		List<Integer> result = new LinkedList<>();
		int[] source = new int[26];
		// source 
		for (char c: p.toCharArray()){
			source[c -'a']++;
		}
		int left = 0; 
		int right = 0;
		int count = p.length();
		while( right < s.length()) {
			if (source[s.charAt(right++) - 'a']-- >= 1) {
				count--;
			}
			if(count == 0) {
				result.add(left);
			}
			if (right - left == p.length() && source[s.charAt(left++) - 'a']++ >= 0 ) {
				count++;
			}
		}
		System.out.println(result);
		return result;
	}
	

	    public ArrayList<ArrayList<Integer>> solve(int n) {
	        if (n == 0 ){
	            return new ArrayList<>();
	        }
	        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

	        ArrayList<Integer> prev = new ArrayList<>();
	        for(int i = 1; i <= n ; i++){
	            ArrayList<Integer> level = new ArrayList<>();
	            if (i == 1){
	                level.add(1);
	                prev.addAll(level);
	                result.add(level);
	                continue;
	            }
	            System.out.println(prev);
	            level.add(prev.get(0));
	            if (i > 2){
	                for( int j = 1; j < i - 1 ; j++){
	                    level.add(prev.get(j -1) + prev.get(j));
	                }
	            }
	            level.add(prev.get(prev.size() -1));
	            prev = new ArrayList<>();
	            prev.addAll(level);
	            result.add(level);
	        }
	        
	        return result;
	    }
}
