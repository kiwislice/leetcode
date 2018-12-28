package leetcode.linkedlist;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		removeNthFromEnd(head, 1);
		
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}

	public static ListNode removeNthFromEndByList(ListNode head, int n) {
		LinkedList<ListNode> list = new LinkedList<>();
		ListNode cur = head;
		while( cur!=null ) {
			list.add(cur);
			cur = cur.next;
		}
		
		int preNodeIndex = list.size()-n-1;
		if( preNodeIndex<0 )
			return head.next;
		
		ListNode node = list.get(preNodeIndex);
		if( n==1 )
			node.next = null;
		else
			node.next = node.next.next;
		
		return head;
	}

}
