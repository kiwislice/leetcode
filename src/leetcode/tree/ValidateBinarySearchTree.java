package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
//		[10,5,15,null,null,6,20] false
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		
//		[2,1,3] true
//		TreeNode root = new TreeNode(2);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(3);
		
//		[3,1,5,0,2,4,6,null,null,null,3] false
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(5);
//		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(2);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(6);
//		root.left.right.right = new TreeNode(3);
		
		System.out.println(isValidBST(root));
	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode root, long min, long max) {
		if( root==null )
			return true;
		if( root.val>=max || root.val<=min )
			return false;
		
		boolean suc = true;
		if( root.left!=null )
			suc &= isValidBST(root.left, min, Math.min(root.val, max));
		if( root.right!=null )
			suc &= isValidBST(root.right, Math.max(root.val, min), max);
		return suc;
	}
	
	public static boolean isValidBSTByInorderTraversal(TreeNode root) {
		if( root==null )
			return true;
		
		boolean rtn = true;
		Integer min = null;
		TreeNode cur = root;
		Deque<TreeNode> stack = new LinkedList<>();
		
		while( cur!=null || !stack.isEmpty() ) {
			while( cur!=null ) {
				stack.addLast(cur);
				cur = cur.left;
			}
			
			cur = stack.removeLast();
			if( min!=null && cur.val<=min )
				return false;
			else
				min = cur.val;
			cur = cur.right;
		}
		
		return rtn;
	}

}
