package com.ds.assignment.amazon;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class GraphAdjacencyList {

	public static void main(String[] args) {
		List[] arr = new List[9];
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = new LinkedList<>();
		}
		add(arr, 0 , 1);
		add(arr, 0 , 3);
		add(arr, 1 , 0);
		add(arr, 2, 3);
		add(arr, 2 , 8);
		add(arr, 3 , 0);
		add(arr, 3 , 2);
		add(arr, 3 , 4);
		add(arr, 3 , 5);
		add(arr, 4 , 3);
		add(arr, 4 , 6);
		add(arr, 5 , 3);
		add(arr, 6 , 4);
		add(arr, 6 , 7);
		add(arr, 7 , 6);
		add(arr, 8 , 2);
		GraphAdjacencyList g = new GraphAdjacencyList();
		g.bfs(arr);
		System.out.println();
		boolean[] seen = new boolean[arr.length];
		g.dfs(arr, 0, seen);
	}
	
	public void bfs(List[] arr) {
		if (arr.length == 0) {
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		List<Integer> visited = new LinkedList<>();
		visited.add(0);
		while(queue.size() > 0) {
			int index = queue.poll();
			System.out.print(index + " ");
			List<Integer> list = arr[index];
			for (Integer e : list) {
				if (!visited.contains(e)) {
				queue.add(e);
				visited.add(e);
				}
			}
		}
	}
	
	public void dfs(List[] arr, int index, boolean[] seen) {
		System.out.print(index + " ");
		seen[index] = true;
		List<Integer> list = arr[index];
		for (Integer ele : list) {
			if (!seen[ele]) {
				seen[ele] = true;
				dfs(arr, ele, seen);
			}
		}
	}
	
	public static void add(List[] arr, int index, int node) {
		arr[index].add(node);
	}
}
