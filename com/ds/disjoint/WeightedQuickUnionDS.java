package com.ds.disjoint;

public class WeightedQuickUnionDS implements DisjoinSet {

	private int parent[];
	private int size[];
	
	public WeightedQuickUnionDS(int n) {
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
			size[i] = 0;
		}
	}
	
	//Find root of p
	public int find(int p) {
		int r = p;
		while(parent[r] > 0 ) {
			r = parent[r];
		}
		size[r]++;
		return r;
	}
	
	@Override
	public void connect(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (size[i] >= size[j]) {
			parent[j] = i;	
		} else {
			parent[i] = j;
		}
			
	}
	
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
}
