package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode rtnHead = new ListNode(-1);
		ListNode curRtn = rtnHead;
		
		while( cur1!=null || cur2!=null ) {
			if( cur1==null || cur2==null ) {
				curRtn.next = cur1==null?cur2:cur1;
				return rtnHead.next;
			}
			else {
				if( cur1.val <= cur2.val ) {
					curRtn.next = cur1;
					cur1 = cur1.next;
				}
				else {
					curRtn.next = cur2;
					cur2 = cur2.next;
				}
				curRtn = curRtn.next;
			}
		}
		return rtnHead.next;
	}

}
