package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode middleNode(ListNode head) {
		ListNode cur = head;
		int len = 0;
		while(cur!=null) {
			cur = cur.next;
			len++;
		}
		
		cur = head;
		int mid = len/2 + 1;
		for(int i=1;i<mid;i++) {
			cur = cur.next;
		}
		return cur;
	}

}
