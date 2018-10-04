package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		System.out.println(inorderTraversal(root));
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> rtn = new LinkedList<>();
		if( root==null )
			return rtn;
		
		TreeNode cur = root;
		Deque<TreeNode> stack = new LinkedList<>();
		
		while( cur!=null || !stack.isEmpty() ) {
			while( cur!=null ) {
				stack.addLast(cur);
				cur = cur.left;
			}
			
			cur = stack.removeLast();
			rtn.add(cur.val);
			cur = cur.right;
		}
		
		return rtn;
	}

	public List<Integer> inorderTraversalByRecursive(TreeNode root) {
		List<Integer> rtn = new LinkedList<>();
		if( root.left!=null )
			rtn.addAll(inorderTraversalByRecursive(root.left));
		
		rtn.add(root.val);
		
		if( root.right!=null )
			rtn.addAll(inorderTraversalByRecursive(root.right));
		
		return rtn;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
