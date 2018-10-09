package leetcode.linkedlist;

public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
		if( head==null )
			return false;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while( slow!=null && fast!=null ) {
			if( slow==fast )
				return true;
			
			slow = slow.next;
			fast = fast.next;
			if( fast==null )
				return false;
			fast = fast.next;
		}
		return false;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
