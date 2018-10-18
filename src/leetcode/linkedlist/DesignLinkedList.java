package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/design-linked-list/
 */
public class DesignLinkedList {

	public static void main(String[] arg) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(1);
		System.out.println(linkedList);
		linkedList.addAtTail(3);
		System.out.println(linkedList);
		linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
		System.out.println(linkedList);
		System.out.println(linkedList.get(1));            // returns 2
		linkedList.deleteAtIndex(1);  // now the linked list is 1->3
		System.out.println(linkedList);
		System.out.println(linkedList.get(1));            // returns 3
		
	}
	
	static class MyLinkedList {

		private Node head;
		
		/** Initialize your data structure here. */
		public MyLinkedList() {
			head = new Node(0);
		}

		/**
		 * Get the value of the index-th node in the linked list. If the index is
		 * invalid, return -1.
		 */
		public int get(int index) {
			Node cur = head.next;
			for(int i=0;i<index&&cur!=null;i++) {
				cur = cur.next;
			}
			return cur==head||cur==null?-1:cur.val;
		}

		/**
		 * Add a node of value val before the first element of the linked list. After
		 * the insertion, the new node will be the first node of the linked list.
		 */
		public void addAtHead(int val) {
			Node cur = head.next;
			head.next = new Node(val);
			head.next.next = cur;
		}

		/** Append a node of value val to the last element of the linked list. */
		public void addAtTail(int val) {
			Node cur = head;
			while(cur.next!=null) {
				cur = cur.next;
			}
			cur.next = new Node(val);
		}

		/**
		 * Add a node of value val before the index-th node in the linked list. If index
		 * equals to the length of linked list, the node will be appended to the end of
		 * linked list. If index is greater than the length, the node will not be
		 * inserted.
		 */
		public void addAtIndex(int index, int val) {
			if( index<0 )
				return ;
			
			Node cur = head;
			for(int i=0;i<index;i++) {
				cur = cur.next;
			}
			if( cur!=null ) {
				Node n = cur.next;
				cur.next = new Node(val);
				cur.next.next = n;
			}	
		}

		/** Delete the index-th node in the linked list, if the index is valid. */
		public void deleteAtIndex(int index) {
			if( index<0 )
				return ;
			
			Node cur = head;
			for(int i=0;i<index;i++) {
				cur = cur.next;
			}
			if( cur!=null && cur.next!=null )
				cur.next = cur.next.next;
		}
		
		private class Node {
			int val;
			Node next;

			Node(int x) {
				val = x;
				next = null;
			}
		}
		
		public String toString() {
			Node cur = head;
			StringBuilder sb = new StringBuilder();
			while(cur.next!=null) {
				cur = cur.next;
				sb.append(cur.val+"->");
			}
			return sb.toString();
		}
		
	}

	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
	 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */

}
