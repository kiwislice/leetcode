package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode asTreeNode(Integer[] ar) {
		if( ar==null || ar.length==0 )
			return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		TreeNode root = new TreeNode(ar[0]);
		queue.add(root);
		
		int index = 1;
		
		while( index<ar.length ) {
			TreeNode node = queue.poll();
			if( ar[index]!=null ) {
				node.left = new TreeNode(ar[index]);
				queue.add(node.left);
			}
			index++;
			if( index<ar.length && ar[index]!=null ) {
				node.right = new TreeNode(ar[index]);
				queue.add(node.right);
			}
			index++;
		}
		return root;
	}
	
}
