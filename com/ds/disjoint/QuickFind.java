package com.ds.disjoint;

//isConnected theta(1) , connected theta(n), constructor theta(n)
public class QuickFind implements DisjoinSet {

	private int[] id;
	
	@Override
	public void connect(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0 ; i < id.length ; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return id[p] == id[q];
	}

	public QuickFind(int n) {
		id = new int[n];
		for (int i = 0 ; i < id.length; i++) {
			id[i] = i;
		}
	}
}
