package com.ds.assignment.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorPractice {

	public static void main(String[] args) {
		// Sort on basis of distance 
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((a, b) -> {
			return (int)(b.distance() - a.distance()); // bigger - smaller = +ve , descending
		});

		maxHeap.add(new Point(2, 2, 1));
		maxHeap.add(new Point(3, 2, 1));
		maxHeap.add(new Point(4, 4, 1));
		maxHeap.add(new Point(4, 4, 2));
		while(!maxHeap.isEmpty()) {
			Point p = maxHeap.poll();
			System.out.println(p.x + "," + p.y);
		}
	// Sort on basis of
		
		

		Comparator<Point> reverseComparator = new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				int c = o2.x - o1.x ;
				if (c == 0) {
					c = o2.y - o1.x;
				}
				if (c == 0) {
					c = o2.z - o1.z;
				}
				return c;
			}
		};
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>(reverseComparator);
		pq.add(new Point(2, 2, 1));
		pq.add(new Point(3, 2, 1));
		pq.add(new Point(4, 4, 1));
		pq.add(new Point(4, 4, 2));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			System.out.println(p.x + "," + p.y + "," + p.z);
		}
		ComparatorPractice p = new ComparatorPractice();
		System.out.println(p.checkPalindrome("aba", 0, 0));
		System.out.println(p.checkPalindrome("aba", 0, 1));
		System.out.println(p.checkPalindrome("aba", 0, 2));
		System.out.println("aba".substring(0, 0));
		System.out.println("aba".substring(0, 1));
		System.out.println("aba".substring(0, 2));
		System.out.println("aba".substring(0, 3));
	}
	
	
    public boolean checkPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}

class Point {
	int x;
	int y;
	int z;
	
	Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z  = z;
	}
	
	public double distance() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}