package leetcode.math;

/**
 * https://leetcode.com/problems/add-two-numbers/solution/
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode rtn = new ListNode(-1);
		ListNode curRtn = rtn;
		
		int sum = 0;
		
		while( cur1!=null || cur2!=null || sum!=0 ) {
			sum += (cur1==null?0:cur1.val) + (cur2==null?0:cur2.val);
			curRtn.next = new ListNode(sum%10);
			sum /= 10;
			
			cur1 = cur1==null?null:cur1.next;
			cur2 = cur2==null?null:cur2.next;
			curRtn = curRtn.next;
		}
		
		return rtn.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
}
