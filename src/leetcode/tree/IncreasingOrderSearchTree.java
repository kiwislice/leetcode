package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {

	public static void main(String[] args) {
		Integer[] ar = {5,3,6,2,4,null,8,1,null,null,null,7,9};

		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(increasingBST(root));
	}

	// 70 ms
	public static TreeNode increasingBST(TreeNode root) {
		if( root==null )
			return null;
		
		LinkedList<TreeNode> list = new LinkedList<>();
		inorder(root, list);
		
		root = list.poll();
		TreeNode cur = root;
		while(cur!=null) {
			cur.left = null;
			cur.right = list.poll();
			cur = cur.right;
		}
		
		return root;
	}

	public static void inorder(TreeNode n, Queue<TreeNode> list) {
		if( n.left!=null )
			inorder(n.left, list);
		
		list.add(n);
		
		if( n.right!=null )
			inorder(n.right, list);
	}
	
	// 40 ms
	public TreeNode increasingBSTByNewNode(TreeNode root) {
		if( root==null )
			return null;
		
		TreeNode newTree = new TreeNode(-1);
		cur = newTree;
		inorder(root);
		return newTree.right;
	}
	
	TreeNode cur;
	
	public void inorder(TreeNode n) {
		if( n.left!=null )
			inorder(n.left);
		
		cur.right = new TreeNode(n.val);
		cur = cur.right;
		
		if( n.right!=null )
			inorder(n.right);
	}
	
}
