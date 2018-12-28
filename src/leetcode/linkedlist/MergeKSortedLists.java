package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
//		ListNode[] lists = {ListNode.as(1,4,5), ListNode.as(1,3,4), ListNode.as(2,6)};
//		ListNode[] lists = {ListNode.as()};
		ListNode[] lists = {ListNode.as(-8,-8,-3,-2,0,2,2,3,3), ListNode.as(-5,-3,1), ListNode.as(-9,-7,-1,4),
				ListNode.as(-10,-4,-4,-4,0,3), ListNode.as(-2,4), ListNode.as(-9,-6,-5,-5,-3,-3,-2,2), 
				ListNode.as(1,3), ListNode.as(-8,-3,-2,1,3)};
		
		System.out.println(mergeKLists(lists));
	}

	// 11 ms, faster than 72.35%
	public static ListNode mergeKLists(ListNode[] lists) {
		if( lists==null || lists.length==0 ) 
			return null;
		
		// 遞迴22合併
		return mergeKLists(lists, 0, lists.length-1);
	}

	public static ListNode mergeKLists(ListNode[] lists, int s, int e) {
		if( e-s>2 ) {
			int dd = (e-s)/2;
			ListNode a = mergeKLists(lists, s, s+dd);
			ListNode b = mergeKLists(lists, s+dd+1, e);
			return merge2Lists(a, b);
		}
		
		ListNode rtn = lists[s];
		for(int i=s+1;i<=e;i++) {
			rtn = merge2Lists(rtn, lists[i]);
		}
		return rtn;
	}

	public static ListNode merge2Lists(ListNode l1, ListNode l2) {
		if( l1==null ) return l2;
		if( l2==null ) return l1;
		
		ListNode root = l1.val<=l2.val?l1:l2;
		ListNode rCur = root;
		ListNode cur2 = l1.val<=l2.val?l2:l1;
		
		while( cur2!=null ) {
			if( rCur.next==null ) {
				rCur.next = cur2;
				break;
			}
			if( rCur.next.val>cur2.val ) {
				ListNode nextR = rCur.next;
				ListNode next2 = cur2.next;
				rCur.next = cur2;
				rCur.next.next = nextR;
				rCur = rCur.next;
				cur2 = next2;
			}
			else {
				rCur = rCur.next;
			}
		}
		
		return root;
	}

	// 22 ms, faster than 42.62%
	public static ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
		if( lists==null || lists.length==0 ) 
			return null;
		
		ListNode root = new ListNode(0);
		ListNode rCur = root;
		
		// 優先順序的Queue裝所有頭
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		
		for(int i=0;i<lists.length;i++) {
			if( lists[i]!=null )
				pq.add(lists[i]);
		}
		
		while( !pq.isEmpty() ) {
			// 直接取出接上，下一個丟進Queue
			rCur.next = pq.poll();
			rCur = rCur.next;
			if( rCur.next!=null )
				pq.add(rCur.next);
		}
		
		return root.next;
	}

	// 115 ms, faster than 18.71%
	public static ListNode mergeKListsByListHead(ListNode[] lists) {
		if( lists==null || lists.length==0 ) 
			return null;
		
		ListNode root = new ListNode(0);
		ListNode rCur = root;
		
		// 準備所有list的頭
		List<ListNode> cur = new ArrayList<>(lists.length);
		for(int i=0;i<lists.length;i++) {
			if( lists[i]!=null )
				cur.add(lists[i]);
		}
		
		int minIndex = 0;
		
		while( !cur.isEmpty() ) {
			// 從所有頭找最小的
			for(int i=0;i<cur.size();i++) {
				minIndex = cur.get(i).val<cur.get(minIndex).val?i:minIndex;
			}
			// 接上，頭跳下一個
			ListNode temp = cur.get(minIndex);
			rCur.next = temp;
			rCur = rCur.next;
			if( temp.next!=null ) {
				cur.set(minIndex, temp.next);
			} else {
				cur.remove(minIndex);
				minIndex = 0;
			}
		}
		
		return root.next;
	}

	// 182 ms, faster than 15.53%
	public static ListNode mergeKListsOld(ListNode[] lists) {
		if( lists==null || lists.length==0 ) 
			return null;
		
		ListNode root = new ListNode(0);
		// 用第1條當底
		root.next = lists[0];
		
		for(int i=1;i<lists.length;i++) {
			ListNode rCur = root;
			// 取得下一條插入
			ListNode cur = lists[i];
			while( cur!=null ) {
				// 後面沒了直接接上
				if( rCur.next==null ) {
					rCur.next = cur;
					break;
				}
				// 要插入的值<=當前值，插入節點
				if( cur.val<=rCur.next.val ) {
					ListNode temp = cur.next;
					cur.next = rCur.next;
					rCur.next = cur;
					cur = temp;
				}
				else {
					rCur = rCur.next;
				}
			}
		}
		
		return root.next;
	}

}
