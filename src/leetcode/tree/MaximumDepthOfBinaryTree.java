package leetcode.tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
	
	public int maxDepth(TreeNode root) {
		if( root==null )
			return 0;
		
		return maxDepth(root, 1);
	}

	public int maxDepth(TreeNode root, int curDepth) {
		int rtn = curDepth;
		if( root.left!=null ) {
			rtn = Math.max(rtn, maxDepth(root.left, curDepth+1));
		}
		if( root.right!=null ) {
			rtn = Math.max(rtn, maxDepth(root.right, curDepth+1));
		}
		return rtn;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
}
