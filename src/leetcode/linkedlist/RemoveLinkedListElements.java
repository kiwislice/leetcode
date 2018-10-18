package leetcode.linkedlist;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		System.out.println(removeElements(head, 1));

	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		
		while(cur!=null && cur.next!=null) {
			if( cur.next.val==val ) {
				cur.next = cur.next.next;
			}
			else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
