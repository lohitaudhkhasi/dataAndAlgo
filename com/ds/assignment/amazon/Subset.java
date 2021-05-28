package com.ds.assignment.amazon;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Subset {

	public static void main(String[] args) {
		int[] arr= { 1, 2, 3};
		Subset s = new Subset();
		s.subset(arr);
	}
	
	public List<List<Integer>> subset(int[] arr){
		List<List<Integer>> subsets = new ArrayList<>();
		printSubset(arr, 0, new ArrayList<Integer>(), subsets);
		return subsets;
	}
	
	/**
	 * Array is created as below 
	 * []
	 * 1 
	 * 1 2
	 * 1 2 3
	 * 1 3
	 * 2
	 * 2 3
	 * 3 
	 * 
	 * @param arr
	 * @param index
	 * @param current
	 * @param subsets
	 */
	public void printSubset(int[] arr, int index, List<Integer> current,  List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(current));
		for(int i = index; i < arr.length; i++) {
			current.add(arr[i]);
			System.out.println("Adding:" + current);
			printSubset(arr, i+1 , current, subsets);
			current.remove(current.size() -1 );
			System.out.println("Removing:" + current);
		}
	}
	

	/** 
	 * Code for INterval problem
	 * @param intervals
	 * @return
	 */
    public int solve(ArrayList<ArrayList<Integer>> intervals) {
        
        if (intervals.size() == 0) {
            return 0;
        }
        
        Collections.sort(intervals, new Comparator<ArrayList<Integer>>(){
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                    return a.get(0) - b.get(0);
                }
            });
        
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(1) - b.get(1);
            }
        });
        pq.add(intervals.get(0));
        
        for ( int i = 1; i < intervals.size(); i++) {
        	ArrayList<Integer> curr = intervals.get(i);
        	ArrayList<Integer> prev = pq.poll();
            if ( curr.get(0) > prev.get(1)) {
                pq.add(prev);
                pq.add(curr);
            } else {
                prev.set(1, curr.get(1));
                pq.add(prev);
            }
        }
        return pq.size();
    }
  
}
