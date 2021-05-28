package com.ds.assignment.amazon;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int [] arr1= { -50, -47, -36, -35, 0, 13, 14, 16};
		int [] arr2 = {-31, 1, 9, 23, 30, 39 };
		for (int i : arr1) {
			list1.add(i);
		}
		for(int i : arr2) {
			list2.add(i);
		}
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(list1, list2));
	}
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> num1, final List<Integer> num2) {
        if (num1.size() == 0) {
            return getMediam(num2);
        } else if (num2.size() == 0) {
            return getMediam(num1);
        }
        //swap the list
        /*if (num2.size() < num1.size()) {
            List temp = num1;
            num1 = num2;
            num2 = num1;
        }*/
        
        int combined = num1.size() + num2.size();
        int lo = 0;
        int hi = num1.size();
        
        while (lo <= hi){
            int partX =  (lo + hi)/2;
            int partY = (combined + 1)/2 - partX;
            
            int leftX = getMax(partX, num1);
            int rightX = getMin(partX, num1);
            
            int leftY = getMax(partY, num2);
            int rightY = getMin(partY, num2);
            
            if (leftX <= rightY && leftY <= rightX){
                if (combined %2 == 0){
                    return (Math.max(leftX, leftY)  + Math.min(rightX, rightY))/2;
                } else {
                    return Math.max(leftX, leftY);
                }
            }
            
            if (leftX > rightY){
                hi = partX - 1;
            } else {
                lo = partX + 1;
            }
        }
        return -1;
    }

    public int getMax(int partition, List<Integer> arr){
        if (partition == 0){
            return Integer.MIN_VALUE;
        } else {
            return arr.get(partition -1);
        }
    }
    
    public int getMin(int partition, List<Integer> arr){
        if (partition == arr.size()){
            return Integer.MAX_VALUE;
        } else {
            return arr.get(partition);
        }
    }
    
    public int getMediam(List<Integer> l){
        int mid = l.size()/2;
        if (l.size() ==0) {
            return (l.get(mid) + l.get(mid + 1))/2;
        } else {
            return l.get(mid);
        }
    }
}