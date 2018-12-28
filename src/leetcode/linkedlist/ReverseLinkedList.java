package leetcode.linkedlist;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode a = null;
		ListNode b = head;
		ListNode c = head==null?null:head.next;
		while(b!=null) {
			b.next = a;
			a = b;
			b = c;
			c = c==null?null:c.next;
		}
		return a;
	}

}
