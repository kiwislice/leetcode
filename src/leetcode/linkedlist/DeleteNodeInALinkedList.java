package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
	    node.next = node.next.next;
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
