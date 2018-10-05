package leetccode.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesFromSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		if( head==null )
			return head;
		
		ListNode rtnHead = new ListNode(head.val);
		ListNode rtnCur = rtnHead;
		ListNode cur = head.next;
		
		while( cur!=null ) {
			if( rtnCur.val!=cur.val ) {
				rtnCur.next = new ListNode(cur.val);
				rtnCur = rtnCur.next;
			}
			cur = cur.next;
		}
		return rtnHead;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
}
