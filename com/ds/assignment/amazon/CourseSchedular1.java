package com.ds.assignment.amazon;

import java.util.*;

public class CourseSchedular1 {
	Map<Integer, List<Integer>> map = new HashMap<>();
	
	public static void main(String[] args) {
		CourseSchedular1 c = new CourseSchedular1();
		//int[][] pre = {{1, 0}};
		int[][] pre = {{1,0},{1,2},{0,1}};
		System.out.println(c.canFinish(3, pre));
	}
	
	public boolean canFinish(int numCourses, int[][] pre) {
		boolean[] visited = new boolean[numCourses];
		for (int[] p : pre) {
			if (!map.containsKey(p[0])) {
				map.put(p[0], new ArrayList<Integer>());
			}
			map.get(p[0]).add(p[1]);
		}
		Map<Integer, Boolean> memo = new HashMap<>();
		for(int i : map.keySet()) {
			if (!check(visited, i, memo)) {
				return false;
			}
		}
		return true;
	}

	public boolean check(boolean[] visited, int start, Map<Integer, Boolean> memo) {
		if (memo.containsKey(start)) {
			return memo.get(start);
		}
		if (visited[start]) {
			return false;
		}

		if (!map.containsKey(start)) {
			return true;
		}
		visited[start] = true;
		for(Integer ele : map.get(start)) {
			if (!check(visited, ele, memo)) {
				return false;
			}
			memo.put(ele, true);
		}
		visited[start] = false;
		String s = new String();

		return true;
	}
}
