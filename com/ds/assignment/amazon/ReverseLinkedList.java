package com.ds.assignment.amazon;

public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedListA list = new LinkedListA();
		list = list.add(list, 1);
		list = list.add(list, 2);
		list = list.add(list, 3);
		list = list.add(list, 4);
		list = list.add(list, 5);
		list = list.add(list, 6);
		list = list.add(list, 7);
		System.out.println(list.size());
		LinkedListA rev = list.reverse(list.head);
		rev.print();
		System.out.println(rev.size());
		int a = 2;
		int b = 5;
		LinkedListA revreseArr = list.reverse(list.head, a, b);
		
	}
}


class LinkedListA {
	Node head;
	int size;
	
	public LinkedListA() {
		size = 0;
	}
	
	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ->");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public int size() {
		return this.size;
	}
	
	public LinkedListA reverse(Node head, int a, int b) {
		LinkedListA list = new LinkedListA();
	//	if (head == nu)
		return list;
	}

	
	
	static class Node{
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public LinkedListA add(LinkedListA list, int k) {
		Node n = new Node(k);
		if (list.head == null) {
			list.head = n;
		} else {
			Node pointer = list.head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = n;
		}
		size++;
		return list;
	}

	public LinkedListA reverse(Node head) {
		LinkedListA list = new LinkedListA();
		if (head == null || head.next == null) {
			list.head = head;
			return list;
		}
		Node newNode = null;
		Node curr = head;
		while (curr.next != null) {
			Node prev = curr;
			curr = curr.next;
			prev.next = newNode;
			newNode = prev;
		}
		curr.next = newNode;
		list.head = curr;
		return list;
	}	
}