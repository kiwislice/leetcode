package leetcode.linkedlist;


public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	static ListNode as(int... is) {
		if( is==null || is.length==0 )
			return null;
		
		ListNode root = new ListNode(0);
		ListNode cur = root;
		for(int i:is) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		return root.next;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode cur = this;
		while(cur!=null) {
			sb.append(cur.val+"->");
			cur = cur.next;
		}
		return sb.toString();
	}
	
}
