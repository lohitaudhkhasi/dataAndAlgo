package com.ds.assignment.amazon;

import java.util.ArrayList;
import java.util.List;

public class Numemployees {
	
	public static void main(String[] args) {
		int[] managers = {2, 2, 4, 6, -1, 4,4,  5};
		int[] inform = {0, 0, 4, 0, 7, 3, 6, 0};
		Numemployees n = new Numemployees();
		List[] adj = new List[managers.length];
		int head = n.form(adj, managers);
		int maxTime = n.findMax(adj,head, inform);
		System.out.println(maxTime);
	}
	
	public int  form(List[] adj , int[] managers) {
		for(int i = 0; i < managers.length;i++) {
			adj[i] = new ArrayList<>();
		}
		int head = -1;
		for (int i = 0; i < managers.length; i++) {
			if (managers[i] == -1) {
				head = i;
			} else {
				adj[managers[i]].add(i);
			}
		}
		return head;
	}
	
	public int findMax(List[] adj, int index, int[] inform) {
		int max = 0;
		List<Integer> children = adj[index];
		int time = inform[index];
		for (Integer c : children) {
			int localTime = time + findMax(adj,c, inform);
			max = Integer.max(max, localTime);
		}
		return max;
	}
}
