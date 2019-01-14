package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode head = ListNode.as(1,2,3,4,5);

		System.out.println(reverseKGroup(head, 3));
	}

	/** 6 ms, faster than 91.15% */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if( k<=1 ) return head;
		
		ListNode rtn = new ListNode(0);
		rtn.next = head;
		ListNode lastChanged = rtn;
		
		ListNode cur = head;
		int count = 1;
		
		while( cur!=null ) {
			if( count<k ) {
				cur = cur.next;
				count++;
			}
			else {
				ListNode next = cur.next;
				ListNode end = lastChanged.next;
				lastChanged.next = reverse(lastChanged.next, cur);
				lastChanged = end;
				lastChanged.next = next;
				
				cur = next;
				count = 1;
			}
		}
		return rtn.next;
	}

	public static ListNode reverse(ListNode head, ListNode end) {
		ListNode cur = head;
		ListNode next;
		
		while( cur!=end ) {
			next = cur.next;
			cur.next = end.next;
			end.next = cur;
			
			cur = next;
		}
		
		return end;
	}
	
}
