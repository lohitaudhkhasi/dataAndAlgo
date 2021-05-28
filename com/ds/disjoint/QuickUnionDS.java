package com.ds.disjoint;

public class QuickUnionDS implements DisjoinSet{
	private int parent[];
	
	public QuickUnionDS(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}
	}
	//Find root of p
	public int find(int p) {
		int r = p;
		while(parent[r] > 0 ) {
			r = parent[r];
		}
		return r;
	}
	@Override
	public void connect(int p, int q) {
		int i = find(p);
		int j = find(q);
		parent[i] = j;
		
	}
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	
}
