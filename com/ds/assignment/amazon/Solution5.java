package com.ds.assignment.amazon;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end; 
    
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Solution5 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return intervals;
        }
        if (intervals.length == 1 && intervals[0].length == 1){
            return intervals;
        }
        List<Interval> li = new LinkedList<>();
        for (int[] interval : intervals){
            Interval i = new Interval(interval[0], interval[1]);
            li.add(i);
        }
        // sort it
        Collections.sort(li, (a, b)-> {
        	return a.start - b.start;
        });
        LinkedHashSet set = new LinkedHashSet();
        String s = "";
        s.sub
        // Priority Queue
	PriorityQueue<Interval> pq = new PriorityQueue<>((l1, l2) -> {
		return l1.end - l2.end;
	});
	pq.add(li.get(0));
	for(int i = 0; i < li.size(); i++) {
		Interval prev = pq.poll();
		Interval curr = li.get(i);
		if (pq.isEmpty() || curr.start < prev.end){
			pq.add(prev);
			pq.add(curr);
		} else {
			prev.end = curr.end;
			pq.add(prev);
		}
	}   }
}