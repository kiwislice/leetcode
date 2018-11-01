package leetcode.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {

	public static void main(String[] args) {
		Integer[] ar = {1,null,2};
//		Integer[] ar = {1,null,2,2};

		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(Arrays.toString(new FindModeInBinarySearchTree().findMode(root)));
	}

	// 4 ms
	public int[] findMode(TreeNode root) {
		if( root==null )
			return new int[] {};
		
		inorder(root);
		if( curCount>maxCount ) {
			list.clear();
			list.add(lastN);
		}
		else if( curCount==maxCount ) {
			list.add(lastN);
		}
		
		int[] rtn = new int[list.size()];
		for(int i=0;i<rtn.length;i++)
			rtn[i] = list.removeFirst();
		return rtn;
	}

	LinkedList<Integer> list = new LinkedList<>();
	int maxCount = 0;
	int curCount = 0;
	Integer lastN = null;
	
	public void inorder(TreeNode t) {
		if( t.left!=null )
			inorder(t.left);
		
		if( lastN!=null ) {
			if( lastN==t.val ) {
				curCount++;
			}
			else {
				if( curCount>maxCount ) {
					list.clear();
					list.add(lastN);
					maxCount = curCount;
				}
				else if( curCount==maxCount ) {
					list.add(lastN);
				}
				lastN = t.val;
				curCount = 1;
			}
		}
		else {
			lastN = t.val;
			curCount = 1;
		}
		
		if( t.right!=null )
			inorder(t.right);
	}
	
	// 20 ms
	public static int[] findModeByMap(TreeNode root) {
		if( root==null )
			return new int[] {};
		
		TreeMap<Integer, Integer> cm = new TreeMap<>();
		count(root, cm);
		Deque<Integer> que = new LinkedList<>();
		int maxCount = 0;
		for(Map.Entry<Integer, Integer> ent:cm.entrySet()) {
			if( ent.getValue()>maxCount ) {
				que.clear();
				que.add(ent.getKey());
				maxCount = ent.getValue();
			}
			else if( ent.getValue()==maxCount ) {
				que.add(ent.getKey());
			}
		}
		int[] rtn = new int[que.size()];
		for(int i=0;i<rtn.length;i++)
			rtn[i] = que.removeFirst();
		return rtn;
	}

	public static void count(TreeNode root, TreeMap<Integer, Integer> cm) {
		int count = cm.getOrDefault(root.val, 0);
		cm.put(root.val, count+1);
		
		if( root.left!=null )
			count(root.left, cm);
		if( root.right!=null )
			count(root.right, cm);
	}
	
}
