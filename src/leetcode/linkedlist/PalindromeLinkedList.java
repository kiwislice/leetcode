package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(ListNode head) {
		ListNode cur = head;
		int len = 0;
		while(cur!=null) {
			cur = cur.next;
			len++;
		}
		
		cur = head;
		for(int i=0;i<len/2;i++) {
			cur = cur.next;
		}
		
		if( len%2==1 )
			cur = cur.next;
		
		cur = reverseList(cur);
		for(int i=0;i<len/2;i++) {
			if( cur.val!=head.val )
				return false;
			cur = cur.next;
			head = head.next;
		}
		return true;
	}

	public static ListNode reverseList(ListNode head) {
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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
