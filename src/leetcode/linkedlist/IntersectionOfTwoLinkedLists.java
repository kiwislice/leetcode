package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] arg) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		ListNode headB = headA;
		
		System.out.println(getIntersectionNode(headA, headB));
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if( headA==null || headB==null )
			return null;
		
		ListNode curA = headA;
		ListNode curB = headB;
		int lenA = 1;
		int lenB = 1;
		
		while(curA.next!=null) {
			curA = curA.next;
			lenA++;
		}
		while(curB.next!=null) {
			curB = curB.next;
			lenB++;
		}
		
		if( curA!=curB )
			return null;
		
		curA = headA;
		curB = headB;
		
		while( lenA>lenB ) {
			curA = curA.next;
			lenA--;
		}	
		while( lenB>lenA ) {
			curB = curB.next;
			lenB--;
		}
		
		while(lenA>0 && curA!=curB) {
			curA = curA.next;
			curB = curB.next;
			lenA--;
		}
		return curA;
	}

}
