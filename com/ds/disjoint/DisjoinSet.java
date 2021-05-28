package com.ds.disjoint;

/*
 * Instead of recording each line, maintain the value to which does it belong to.
 */
public interface DisjoinSet {
	void connect(int p, int q);
	boolean isConnected(int p, int q);
}

/*If we choose data structure of List<Ste<Integer>> , it would be very slow.
 * As we would have to iterate to N-1 sets to check if any element and corresponding elements exists, for isConnected function
 * 
 * Better approach, against each number check that to which group does it belong to. And maintain an array, and update array value as group changes.
 */
