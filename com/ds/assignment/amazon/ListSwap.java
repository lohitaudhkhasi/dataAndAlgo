package com.ds.assignment.amazon;

public class ListSwap {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
	//	head.next.next.next = new ListNode(4);
	//	head.next.next.next.next = new ListNode(5);
	//	head.next.next.next.next.next = new ListNode(6);
		
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(5);
		head2.next.next = new ListNode(7);
		
		
		//head2.next.next.next = new ListNode(4);
	//	head2.next.next.next.next = new ListNode(5);
	//	head2.next.next.next.next.next = new ListNode(6);
		ListSwap s = new ListSwap();
		ListNode n = s.mergeTwoLists(head, head2);
	//	ListNode n = s.swapPairs(head);
		//ListNode n = s.reorderList(head);	
		System.out.println(n);
	}
	
	public ListNode insert(ListNode node, int key) {
		
		return node;
	}
	
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if ( a == null){
            return a;
        }
        if (b == null){
            return a;
        }
        if (a == null && b == null){
            return null;
        }
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while ( a != null && b != null){
            if (a.val < b.val){
                curr.next = a;
                a = a.next;
            } else if ( a.val > b.val){
                curr.next = b;
                b = b.next;
            } else {
               	curr.next = a;
               	curr = curr.next;
                curr.next = b;
                a = a.next;
                b = b.next;
            }
            curr = curr.next;
        }
        if (a != null){
            curr.next = a;
        }
        if ( b != null){
            curr.next = b;
        }
        return head.next;
    }


    public ListNode reorderList(ListNode root) {
        int size = size(root);
        if (size <= 2){
            return root;
        }
        int mid = size/2;
        ListNode curr = root;
        while (mid > 1){
            curr = curr.next;
            mid--;
        }
        ListNode second = reverse(curr.next);
        curr.next = null;
        curr = root;
        root = merge(curr, second);
        return root;
    }

    public ListNode merge(ListNode first,ListNode second){
        ListNode curr = first;
        while ( second != null){
        	ListNode next = curr.next;
        	ListNode nextSecond = second.next;
            curr.next = second;
            if (next == null) {
            	break;
            }
            second.next = next;
            second = nextSecond;
            curr = next;
        }
        return first;
    }   
    
    public ListNode reverse(ListNode root){
        ListNode curr = root;
        ListNode prev = null;
        while (curr != null){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
    
    public int size(ListNode n){
        int size = 0;
        while (n != null){
            n = n.next;
            size++;
        } 
        return size;
    }
    

    public ListNode swapPairs(ListNode head) {
    	ListNode tempNode = new ListNode(0);
    	tempNode.next = head;
        ListNode curr = tempNode;
        while (curr.next != null && curr.next.next != null){
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;
            n1.next = n2.next;
            curr.next = n2;
            curr.next.next = n1;
            curr = curr.next.next;
        }
        return tempNode.next;
    }

}

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}