package leetcode.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		h.next = h;
		
		System.out.println(detectCycle(h));
	}
	
	/**
	 * 解法說明
	 * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
	 */
	public static ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}
		
		if( !hasCycle )
			return null;
		
		fast = head;
		while( slow!=fast ) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public ListNode detectCycleByBruteForce(ListNode head) {
		if (head == null)
			return null;

		ListNode nodeOnCycle = hasCycle(head);
		if( nodeOnCycle==null )
			return null;
		
		List<ListNode> list = new LinkedList<>();
		ListNode cur = head;
		while (cur!=nodeOnCycle) {
			list.add(cur);
			cur = cur.next;
		}
		list.add(cur);
		
		cur = nodeOnCycle.next;
		while( cur!=null ) {
			if( list.contains(cur) ) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	public static ListNode hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null) {
			if (slow == fast)
				return slow;

			slow = slow.next;
			fast = fast.next;
			if (fast == null)
				return null;
			fast = fast.next;
		}
		return null;
	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
