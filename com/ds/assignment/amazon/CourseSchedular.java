package com.ds.assignment.amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedular {

	static int[][] p = {
			//{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}
			{1, 2}, {4, 3}, {5, 4}, {5, 3}
	};
	
	public static void main(String[] args) {
		CourseSchedular cs = new CourseSchedular();
		List<Integer>[] adjList = cs.createAdj(p, 6);
		boolean canComplete = cs.detectLoop(adjList, 6);
		System.out.println(canComplete);
		boolean tp = cs.topologicalSort(6);
		System.out.println(tp);
	}
	
	// T:O(p)
	public List<Integer>[] createAdj(int[][] p, int n) {
		List<Integer>[] adjList = new List[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < p.length ; i++) {
			int dependency = p[i][1];
			int course = p[i][0];
			adjList[course].add(dependency);
		}
		return adjList;
	}
	
	// t: o (n^3)
	public boolean detectLoop(List<Integer>[] adjList, int n) {
		// For each vertex 
		// t:O(N)
		boolean isLoop = false;
		for (int i = 0; i < n; i++) {
			// Run bfs to see if i = start is seen again
			 if (bfs(adjList, i , n)) {
				 isLoop = true;
				 break;
			 }
		}
		return isLoop;
	}
	
	//O(N*2)
	public boolean bfs(List<Integer>[] adj,int start,  int n) {
		System.out.println("Start: " + start);
		Queue<Integer> q = new LinkedList<>();
		boolean[] seen = new boolean[n];
		List<Integer> list = adj[start];
		for (Integer h : list) {
			q.add(h);
			seen[h] = true;
		}
		// O(N*2)
		while(q.size() > 0) {
			Integer ele = q.poll();
			System.out.print(ele + " ");
			if (ele == start) {
				return true;
			}
			List<Integer> l = adj[ele];
			for (int e : l) {
				if (!seen[e]) {
					q.add(e);
					seen[e] = true;
				}
			}
		}
		System.out.println();
		return false;
	}
	
	// Creating adjList and InDegree Map together
	public boolean topologicalSort(int n) {
		List<Integer>[] adjList = new List[n];
		int[] inDegreeMap = new int[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < p.length ; i++) {
			int dependency = p[i][1];
			int course = p[i][0];
			adjList[dependency].add(course);
			inDegreeMap[course]++;
		}
		
		// Search 0 in in Degree, use binary Search
		int num = n;
		Stack<Integer> stack = new Stack<>();
		findZero(inDegreeMap, stack);
		while ( stack.size() > 0) {
			// Use Stack to 
			Integer index = stack.pop();
			num--;
			List<Integer> list = adjList[index];
			for (Integer e : list) {
				inDegreeMap[e]--;
				if (inDegreeMap[e] == 0) {
					stack.push(e);
				}
			}
		}
		if (num < n ) {
			return false;
		}
		return true;
	}
	
	public void findZero(int[] arr, Stack stack) {
		for (int i = 0 ; i < arr.length; i++) {
			if (arr[i] == 0) {
				stack.push(i);
			}
		}
	}
}
