package com.ds.list;

import java.net.NetworkInterface;

public class IntList {

	private IntList rear;
	private int first;
	
	IntList( int f,IntList r){
		this.first = f;
		this.rear = r;
	}
	
	public static void main(String args[]) {
		IntList l = new IntList(5, null);
		l = new IntList(15, l);
		l = new IntList(20, l);
	//	printList(l);
	//	IntList dList = dincList(l ,2);
		//printList(dList);
		//printList(l);
		IntList sList = incrList(l ,2);
		printList(sList);
		printList(l);
	}

	public static void printList(IntList l ) {
		StringBuilder b = new StringBuilder();
		while (l.rear != null) {
			b.append(l.first  + "-->");
			l = l.rear;
		}
		b.append(l.first);
		System.out.println(b.toString());
	}
	
	public static IntList incrList (IntList i, int x) {
		if (i.rear == null) {
			return new IntList(i.first + x, null);
		}
		IntList n = incrList(i.rear, x);
		return new IntList(i.first + x, n);
	}
	
	public static IntList dincList(IntList i, int x) {
		IntList head = i;
		while (i.rear != null) {
			i.first +=x;
			i = i.rear;
		}
		i.first+=x;
		return head;
	}
}
