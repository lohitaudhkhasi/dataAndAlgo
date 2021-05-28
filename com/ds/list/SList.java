package com.ds.list;

/**
 * Concept of Sentinel node which tells that first would always point to next node,
 *  so its easier to implement empty list
 * @author lohaudhk
 *
 */
public class SList {
	
	private static  class IntNode {
		public int item;
		public IntNode next;
		
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}
	}
	private IntNode sentinel;
//	private IntNode first;
	private static int count = 0;
	
	public SList() {
		sentinel = new IntNode(63, null);
		count = 0;
	}
	
	public SList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		count = 1;
	}
	
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		//first = new IntNode(x, first); 
		count++;
	}
	
	public int getFirst() {
		//return first.item;
		return sentinel.next.item;
	}
	
	public static void main(String args[]) {
		SList list = new SList(10);
	}
	
	public void addLast(int x) {
		IntNode last = new IntNode(x, null);
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = last;
		count++;
	}
	
	private static int size(IntNode p) {
/*		if ( p == null) {
			return 1;
		}
		return 1 + size(p.next);*/
		return count;
	}
	
	public int size() {
		return size(sentinel.next);
	}
}
